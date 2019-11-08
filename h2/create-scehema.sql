-- IF NOT EXISTS (SELECT H2
--     FROM information_schema.schemata
--     WHERE schema_name = 'newSchemaName' )
-- BEGIN
--     EXEC sp_executesql N'CREATE SCHEMA NewSchemaName;';
-- END
CREATE SCHEMA ANGSPR
