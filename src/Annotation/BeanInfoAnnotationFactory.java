package Annotation;


import java.beans.Introspector;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;
@SupportedAnnotationTypes("Annotation.XmlBean")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class BeanInfoAnnotationFactory extends AbstractProcessor{

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv) {
	 
        for(TypeElement t : annotations){
			Map<String, XmlBean> props = new LinkedHashMap();
            String beanClassName = null;
            for(Element e:roundEnv.getElementsAnnotatedWith(t)){
                String mname = e.getSimpleName().toString();
                String[] prefixes = {"get", "set" , "is"};
                boolean found = false;
                for(int i=0;!found && i<prefixes.length;i++){
                    if(mname.startsWith(prefixes[i])){
                        found = true;
                        int start = prefixes[i].length();
                        String name = Introspector.decapitalize(mname.substring(start));
                        props.put(name, e.getAnnotation(XmlBean.class));
                    }
                }
                if(!found){
                    processingEnv.getMessager().printMessage(Kind.ERROR, 
                        "&XmlBean must be applied to getXxx, setXxx, or isXxx method", e);
                }else if(beanClassName==null){
                    beanClassName = ((TypeElement)e.getEnclosingElement()).getQualifiedName().toString();
                }
            }
            try{
                if(beanClassName != null){
                    writeBeanInfoFile(beanClassName, props);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return true;
    }

    private void writeBeanInfoFile(String beanClassName,
            Map<String, XmlBean> props) throws IOException{
        JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(
                beanClassName + "BeanInfo");
        PrintWriter out = new PrintWriter(sourceFile.openWriter());
        int i = beanClassName.lastIndexOf(".");
        if(i>0){
            out.print("package ");
            out.print(beanClassName.substring(0, i));
            out.print(";");
        }
        out.print("public class ");
        out.print(beanClassName.substring(i + 1));
        out.println("BeanInfo extends java.beans.SimpleBeanInfo");
        out.print("{");
        out.print("    public java.beans.PropertyDescriptor[] getPropertyDescriptors(){");
        out.println("        try{");
        for(Map.Entry<String, XmlBean> e :props.entrySet()){
            out.print("            java.beans.PropertyDescriptor");
            out.print(e.getKey());
            out.println("Descriptor");
            out.print("                = new java.beans.PropertyDescriptory(\"");
            out.print(e.getKey());
            out.print("\", ");
            out.print(beanClassName);
            out.println(".class);");
            String ed = e.getValue().editor().toString();
            if(!ed.equals("")){
                out.print("            ");
                out.print(e.getKey());
                out.print("Descriptor.setPropertyEditorClass(");
                out.print(ed);
                out.println(".class);");
            }
        }
        out.println("           return new java.beans.PropertyDescriptor[]{");
        boolean first = true;
        for(String p : props.keySet()){
            if(first){
                first = false;
            }else{
                out.print(",");
            }
            out.println();
            out.print("        ");
            out.print(p);
            out.print("Descriptor");
        }
        out.println();
        out.println("            };");
        out.println("        }");
        out.println("        catch(java.beans.IntrospectionException e){");
        out.println("            e.printStackTrace();");
        out.println("        return null;");
        out.println("        }");
        out.println("    }");
        out.println("}");
        out.close();
    }
    
}