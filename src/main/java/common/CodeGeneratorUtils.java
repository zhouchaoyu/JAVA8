package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGeneratorUtils {
	//�����ļ�������Ŀ·��
    private static String baseProjectPath = "D:\\gennare";

    //��������
    private static String basePackage="com.kichun.ucenter";
    //����
    private static String authorName="wangqichang";
    //Ҫ���ɵı���
    private static String[] tables= {"t_role","t_resource","t_role_resource","t_user_role"};
    //tableǰ׺
    private static String prefix="t_";

    //���ݿ�������Ҫ��
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:log4jdbc:mysql://127.0.0.1:3306/kichun_dev?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true";
    private static String username = "��������";
    private static String password = "����Ҳ��������";


    public static void main(String[] args) {


        AutoGenerator gen = new AutoGenerator();

        /**
         * ���ݿ�����
         */
        gen.setDataSource(new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setDriverName(driverName)
                .setUrl(url)
                .setUsername(username)
                .setPassword(password)
                .setTypeConvert(new MySqlTypeConvert() {
                    // �Զ������ݿ���ֶ�����ת������ѡ��
                    @Override
                    public DbColumnType processTypeConvert(String fieldType) {
                        System.out.println("ת�����ͣ�" + fieldType);
                        // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                        //    return DbColumnType.BOOLEAN;
                        // }
                        return super.processTypeConvert(fieldType);
                    }
                }));

        /**
         * ȫ������
         */
        gen.setGlobalConfig(new GlobalConfig()
                .setOutputDir( baseProjectPath + "/src/main/java")//���Ŀ¼
                .setFileOverride(true)// �Ƿ񸲸��ļ�
                .setActiveRecord(true)// ���� activeRecord ģʽ
                .setEnableCache(false)// XML ��������
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setOpen(false)//���ɺ���ļ���
                .setAuthor(authorName)
                // �Զ����ļ�������ע�� %s ���Զ�����ʵ�����ԣ�
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController")
        );

        /**
         * ��������
         */
        gen.setStrategy(new StrategyConfig()
                // .setCapitalMode(true)// ȫ�ִ�д����
                //.setDbColumnUnderline(true)//ȫ���»�������
                .setTablePrefix(new String[]{prefix})// �˴������޸�Ϊ���ı�ǰ׺
                .setNaming(NamingStrategy.underline_to_camel)// �������ɲ���
                .setInclude(tables) // ��Ҫ���ɵı�
                .setRestControllerStyle(true)
                //.setExclude(new String[]{"test"}) // �ų����ɵı�
                // �Զ���ʵ�常��
                // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                // �Զ���ʵ�壬�����ֶ�
                //.setSuperEntityColumns(new String[]{"test_id"})
                //.setTableFillList(tableFillList)
                // �Զ��� mapper ���� Ĭ��BaseMapper
                //.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper")
                // �Զ��� service ���� Ĭ��IService
                // .setSuperServiceClass("com.baomidou.demo.TestService")
                // �Զ��� service ʵ���ุ�� Ĭ��ServiceImpl
                // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                // �Զ��� controller ����
                //.setSuperControllerClass("com.kichun."+packageName+".controller.AbstractController")
                // ��ʵ�塿�Ƿ������ֶγ�����Ĭ�� false��
                // public static final String ID = "test_id";
                // .setEntityColumnConstant(true)
                // ��ʵ�塿�Ƿ�Ϊ������ģ�ͣ�Ĭ�� false��
                // public User setName(String name) {this.name = name; return this;}
                // .setEntityBuilderModel(true)
                // ��ʵ�塿�Ƿ�Ϊlombokģ�ͣ�Ĭ�� false��<a href="https://projectlombok.org/">document</a>
                .setEntityLombokModel(true)
                // Boolean�����ֶ��Ƿ��Ƴ�isǰ׺����
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        );

        /**
         * ������
         */
        gen.setPackageInfo(new PackageConfig()
                        //.setModuleName("User")
                        .setParent(basePackage)// �Զ����·��
                        .setController("controller")// �����ǿ�����������Ĭ�� web
                        .setEntity("entity")
                        .setMapper("dao")
                        .setService("service")
                        .setServiceImpl("service.impl")
                        .setXml("mapper")
                        );

        /**
         * ע���Զ�������
         */
        // ע���Զ������ã������� VM ��ʹ�� cfg.abc ���õ�ֵ
        InjectionConfig abc = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        //�Զ����ļ����λ�ã��Ǳ��룩
        List<FileOutConfig> fileOutList = new ArrayList<>();
        fileOutList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return baseProjectPath + "/src/main/resources/mappers/" + tableInfo.getEntityName() + ".xml";
            }
        });
        abc.setFileOutConfigList(fileOutList);
        gen.setCfg(abc);

        /**
         * ָ��ģ������ Ĭ����VelocityTemplateEngine ����Ҫ���������������
         */
        gen.setTemplateEngine(new FreemarkerTemplateEngine());

        /**
         * ģ������
         */
        gen.setTemplate(
                // �ر�Ĭ�� xml ���ɣ��������� �� ��Ŀ¼
                new TemplateConfig().setXml(null)
                // �Զ���ģ�����ã�ģ����Բο�Դ�� /mybatis-plus/src/main/resources/template ʹ�� copy
                // ������Ŀ src/main/resources/template Ŀ¼�£�ģ������Ҳ���Զ����������ã�
                // .setController("...");
                // .setEntity("...");
                // .setMapper("...");
                // .setXml("...");
                // .setService("...");
                // .setServiceImpl("...");
        );

        // ִ������
        gen.execute();
    }
}




