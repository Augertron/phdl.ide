/**
 */
package edu.byu.ee.phdl.phdl.impl;

import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Vector;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.VectorImpl#getMsb <em>Msb</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.VectorImpl#isVector <em>Vector</em>}</li>
 *   <li>{@link edu.byu.ee.phdl.phdl.impl.VectorImpl#getLsb <em>Lsb</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VectorImpl extends MinimalEObjectImpl.Container implements Vector
{
  /**
   * The default value of the '{@link #getMsb() <em>Msb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsb()
   * @generated
   * @ordered
   */
  protected static final int MSB_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getMsb() <em>Msb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMsb()
   * @generated
   * @ordered
   */
  protected int msb = MSB_EDEFAULT;

  /**
   * The default value of the '{@link #isVector() <em>Vector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVector()
   * @generated
   * @ordered
   */
  protected static final boolean VECTOR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVector() <em>Vector</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVector()
   * @generated
   * @ordered
   */
  protected boolean vector = VECTOR_EDEFAULT;

  /**
   * The default value of the '{@link #getLsb() <em>Lsb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLsb()
   * @generated
   * @ordered
   */
  protected static final int LSB_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLsb() <em>Lsb</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLsb()
   * @generated
   * @ordered
   */
  protected int lsb = LSB_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VectorImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return PhdlPackage.Literals.VECTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getMsb()
  {
    return msb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMsb(int newMsb)
  {
    int oldMsb = msb;
    msb = newMsb;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.VECTOR__MSB, oldMsb, msb));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVector()
  {
    return vector;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVector(boolean newVector)
  {
    boolean oldVector = vector;
    vector = newVector;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.VECTOR__VECTOR, oldVector, vector));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLsb()
  {
    return lsb;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLsb(int newLsb)
  {
    int oldLsb = lsb;
    lsb = newLsb;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, PhdlPackage.VECTOR__LSB, oldLsb, lsb));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case PhdlPackage.VECTOR__MSB:
        return getMsb();
      case PhdlPackage.VECTOR__VECTOR:
        return isVector();
      case PhdlPackage.VECTOR__LSB:
        return getLsb();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case PhdlPackage.VECTOR__MSB:
        setMsb((Integer)newValue);
        return;
      case PhdlPackage.VECTOR__VECTOR:
        setVector((Boolean)newValue);
        return;
      case PhdlPackage.VECTOR__LSB:
        setLsb((Integer)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case PhdlPackage.VECTOR__MSB:
        setMsb(MSB_EDEFAULT);
        return;
      case PhdlPackage.VECTOR__VECTOR:
        setVector(VECTOR_EDEFAULT);
        return;
      case PhdlPackage.VECTOR__LSB:
        setLsb(LSB_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case PhdlPackage.VECTOR__MSB:
        return msb != MSB_EDEFAULT;
      case PhdlPackage.VECTOR__VECTOR:
        return vector != VECTOR_EDEFAULT;
      case PhdlPackage.VECTOR__LSB:
        return lsb != LSB_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (msb: ");
    result.append(msb);
    result.append(", vector: ");
    result.append(vector);
    result.append(", lsb: ");
    result.append(lsb);
    result.append(')');
    return result.toString();
  }

} //VectorImpl
