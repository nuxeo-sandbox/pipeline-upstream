node {
//        copyRemoteArtifacts from: 'jenkins://0e359358d5afcea47e2a002480c897d4/pipeline-upstream/master', mapper: [$class: 'FlattenDirectoriesArtifactNameMapper'], selector: [$class: 'UpstreamRemoteBuildSelector', fallbackToLastSuccessful: false, pickFirst: true]
     try {
     step ([$class: 'CopyArtifact',
                projectName: 'downstream',
                mapper: [$class: 'FlattenDirectoriesArtifactNameMapper'],
                selector: [$class: 'TriggeredBuildSelector', fallbackToLastSuccessful: false])
     } catch (IOException cause) {
       echo cause
       throw cause
     }
}
