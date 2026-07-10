def gitignore = new File(new File(request.outputDirectory, request.artifactId), "gitignore")
if (gitignore.exists()) {
    gitignore.renameTo(new File(gitignore.getParentFile(), ".gitignore"))
    println "Renamed gitignore to .gitignore"
} else {
    println "WARNING: gitignore file not found at " + gitignore.getAbsolutePath()
}
