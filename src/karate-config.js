function () {

  var env = (karate.env ? karate.env : 'stg').toLowerCase(); // get java system property 'karate.env'

  // only allows this envs or fallback to dev
  if (['dev', 'stg', 'int', 'prd', 'local'].indexOf(env) < 0) {
    env = dev;
  }

  var config = {
    env: env
  }


  karate.configure('retry',{ count:5, interval:10000});
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 60000);
  return config;
}