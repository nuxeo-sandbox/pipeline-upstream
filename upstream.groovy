node {
    checkout scm
    archiveArtifacts artifacts: 'placeholder.txt', onlyIfSuccessful: true
}
