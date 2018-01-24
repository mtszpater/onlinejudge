/** Oauth - populate the oauth_client_details table */
INSERT INTO `oauth_client_details` (`client_id`, `client_secret`, `scope`, `authorized_grant_types`, `access_token_validity`, `additional_information`)
VALUES
  ('web', 'secret', 'read', 'authorization_code,password,refresh_token,implicit', '2000', '{}')
ON DUPLICATE KEY UPDATE
  client_secret          = VALUES(`client_secret`),
  scope                  = VALUES(`scope`),
  authorized_grant_types = VALUES(`authorized_grant_types`),
  access_token_validity  = VALUES(`access_token_validity`),
  additional_information = VALUES(`additional_information`);

INSERT INTO `onlinejudge`.`account` (`id`, `password`, `username`) VALUES ('	1	', 'admin', 'admin')
ON DUPLICATE KEY UPDATE
  password = VALUES(`password`),
  username = VALUES(`username`);