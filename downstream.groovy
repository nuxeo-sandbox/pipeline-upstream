node {
    echo 'hello world'
    try {
//        copyRemoteArtifacts from: 'jenkins://0e359358d5afcea47e2a002480c897d4/pipeline-upstream/master', mapper: [$class: 'FlattenDirectoriesArtifactNameMapper'], selector: [$class: 'UpstreamRemoteBuildSelector', fallbackToLastSuccessful: false, pickFirst: true]
        step ([$class: 'CopyArtifact',
                projectName: 'sourceproject',
                from: 'pipeline-upstream/master',
                mapper: [$class: 'FlattenDirectoriesArtifactNameMapper'],
                selector: [$class: 'TriggeredBuildSelector', fallbackToLastSuccessful: false, upstreamFilterStrategy: UseNewest],
                filter: 'placeholder*'])
    } catch (IOException cause) {
        echo 'artifact unavailable'
    }
}
