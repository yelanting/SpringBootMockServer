use autotest_platform_mockserver;

SELECT concat('DROP TABLE IF EXISTS ', table_name, ';')
FROM information_schema.tables
WHERE table_schema = 'autotest_platform_mockserver';

SET FOREIGN_KEY_CHECKS=0;
