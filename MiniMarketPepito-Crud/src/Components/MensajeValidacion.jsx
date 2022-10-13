import React from 'react'

const MensajeValidacion = ({ tipo, children }) => {
  return (
    <div className={`${tipo} `}>{children}</div>
  )
}

export default MensajeValidacion