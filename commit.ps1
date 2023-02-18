Write-Host "Commit Message:"

$Message = Read-Host


function  GIT_COMMIT() {
    git checkout front-end
    git add *
    git commit -m $Message
    git push https://github.com/Tandhish/kwality_kitchen.github.io.git front-end
}

GIT_COMMIT