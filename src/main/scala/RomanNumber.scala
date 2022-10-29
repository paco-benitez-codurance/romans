enum Roman:
    case Basic(character: Char)
    case Compose(basics: Seq[Basic])

    def asString() = this match
        case Basic(character) => String.valueOf(character)
        case _ => ???
    