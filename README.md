my api for games using slick2d

Prerequisites :

mvn install:install-file -Dfile=./lib_lwjgl/jar/lwjgl.jar -DgroupId=org.lwjgl.lwjgl -DartifactId=lwjgl -Dversion=1 -Dpackaging=jar  
mvn install:install-file -Dfile=./lib_lwjgl/jar/lwjgl_util.jar -DgroupId=org.lwjgl.lwjgl -DartifactId=lwjgl_util -Dversion=1 -Dpackaging=jar  

mvn install:install-file -Dfile=./lib_slick/jorbis-0.0.15.jar -DgroupId=com.jcraft -DartifactId=jorbis -Dversion=0.0.15 -Dpackaging=jar  
mvn install:install-file -Dfile=./lib_slick/jogg-0.0.7.jar -DgroupId=com.jcraft.jogg -DartifactId=jogg -Dversion=0.0.7 -Dpackaging=jar  

mvn install:install-file -Dfile=./lib_slick/slick.jar -DgroupId=org.newdawn.slick -DartifactId=slick -Dversion=1 -Dpackaging=jar  
mvn install:install-file -Dfile=./lib_slick/slick-util.jar -DgroupId=org.newdawn.slick -DartifactId=slick-util -Dversion=1 -Dpackaging=jar  
