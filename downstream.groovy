node {
    echo 'hello world'
//        copyRemoteArtifacts from: 'jenkins://0e359358d5afcea47e2a002480c897d4/pipeline-upstream/master', mapper: [$class: 'FlattenDirectoriesArtifactNameMapper'], selector: [$class: 'UpstreamRemoteBuildSelector', fallbackToLastSuccessful: false, pickFirst: true]
        step ([$class: 'CopyArtifact',
                projectName: 'sourceproject',
                from: 'pipeline-upstream/master',
                target: 'upstream',
                mapper: [$class: 'FlattenDirectoriesArtifactNameMapper'],
                selector: [$class: 'TriggeredBuildSelector', fallbackToLastSuccessful: false],
                filter: '**/*.txt'])
}
