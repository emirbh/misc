package drr.standards.iosco.upi;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import drr.standards.iosco.upi.meta.AnnaDsbAGRIMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbAGRI", builder=AnnaDsbAGRI.AnnaDsbAGRIBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbAGRI", model="drr", builder=AnnaDsbAGRI.AnnaDsbAGRIBuilderImpl.class, version="7.7.0")
public interface AnnaDsbAGRI extends RosettaModelObject {

	AnnaDsbAGRIMeta metaData = new AnnaDsbAGRIMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbEmpty getSEAF();
	AnnaDsbAdditionalSubProduct getGRIN();
	AnnaDsbAdditionalSubProduct getOOLI();
	AnnaDsbEmpty getPOTA();
	AnnaDsbEmpty getDIRY();
	AnnaDsbEmpty getFRST();
	AnnaDsbAdditionalSubProduct getSOFT();
	AnnaDsbEmpty getLSTK();
	AnnaDsbAdditionalSubProduct getGROS();

	/*********************** Build Methods  ***********************/
	AnnaDsbAGRI build();
	
	AnnaDsbAGRI.AnnaDsbAGRIBuilder toBuilder();
	
	static AnnaDsbAGRI.AnnaDsbAGRIBuilder builder() {
		return new AnnaDsbAGRI.AnnaDsbAGRIBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbAGRI> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbAGRI> getType() {
		return AnnaDsbAGRI.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("SEAF"), processor, AnnaDsbEmpty.class, getSEAF());
		processRosetta(path.newSubPath("GRIN"), processor, AnnaDsbAdditionalSubProduct.class, getGRIN());
		processRosetta(path.newSubPath("OOLI"), processor, AnnaDsbAdditionalSubProduct.class, getOOLI());
		processRosetta(path.newSubPath("POTA"), processor, AnnaDsbEmpty.class, getPOTA());
		processRosetta(path.newSubPath("DIRY"), processor, AnnaDsbEmpty.class, getDIRY());
		processRosetta(path.newSubPath("FRST"), processor, AnnaDsbEmpty.class, getFRST());
		processRosetta(path.newSubPath("SOFT"), processor, AnnaDsbAdditionalSubProduct.class, getSOFT());
		processRosetta(path.newSubPath("LSTK"), processor, AnnaDsbEmpty.class, getLSTK());
		processRosetta(path.newSubPath("GROS"), processor, AnnaDsbAdditionalSubProduct.class, getGROS());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbAGRIBuilder extends AnnaDsbAGRI, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateSEAF();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getSEAF();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateGRIN();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getGRIN();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateOOLI();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOOLI();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreatePOTA();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getPOTA();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateDIRY();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getDIRY();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateFRST();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getFRST();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateSOFT();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getSOFT();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateLSTK();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getLSTK();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateGROS();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getGROS();
		AnnaDsbAGRI.AnnaDsbAGRIBuilder setSEAF(AnnaDsbEmpty SEAF);
		AnnaDsbAGRI.AnnaDsbAGRIBuilder setGRIN(AnnaDsbAdditionalSubProduct GRIN);
		AnnaDsbAGRI.AnnaDsbAGRIBuilder setOOLI(AnnaDsbAdditionalSubProduct OOLI);
		AnnaDsbAGRI.AnnaDsbAGRIBuilder setPOTA(AnnaDsbEmpty POTA);
		AnnaDsbAGRI.AnnaDsbAGRIBuilder setDIRY(AnnaDsbEmpty DIRY);
		AnnaDsbAGRI.AnnaDsbAGRIBuilder setFRST(AnnaDsbEmpty FRST);
		AnnaDsbAGRI.AnnaDsbAGRIBuilder setSOFT(AnnaDsbAdditionalSubProduct SOFT);
		AnnaDsbAGRI.AnnaDsbAGRIBuilder setLSTK(AnnaDsbEmpty LSTK);
		AnnaDsbAGRI.AnnaDsbAGRIBuilder setGROS(AnnaDsbAdditionalSubProduct GROS);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("SEAF"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getSEAF());
			processRosetta(path.newSubPath("GRIN"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getGRIN());
			processRosetta(path.newSubPath("OOLI"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getOOLI());
			processRosetta(path.newSubPath("POTA"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getPOTA());
			processRosetta(path.newSubPath("DIRY"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getDIRY());
			processRosetta(path.newSubPath("FRST"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getFRST());
			processRosetta(path.newSubPath("SOFT"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getSOFT());
			processRosetta(path.newSubPath("LSTK"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getLSTK());
			processRosetta(path.newSubPath("GROS"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getGROS());
		}
		

		AnnaDsbAGRI.AnnaDsbAGRIBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbAGRI  ***********************/
	class AnnaDsbAGRIImpl implements AnnaDsbAGRI {
		private final AnnaDsbEmpty sEAF;
		private final AnnaDsbAdditionalSubProduct gRIN;
		private final AnnaDsbAdditionalSubProduct oOLI;
		private final AnnaDsbEmpty pOTA;
		private final AnnaDsbEmpty dIRY;
		private final AnnaDsbEmpty fRST;
		private final AnnaDsbAdditionalSubProduct sOFT;
		private final AnnaDsbEmpty lSTK;
		private final AnnaDsbAdditionalSubProduct gROS;
		
		protected AnnaDsbAGRIImpl(AnnaDsbAGRI.AnnaDsbAGRIBuilder builder) {
			this.sEAF = ofNullable(builder.getSEAF()).map(f->f.build()).orElse(null);
			this.gRIN = ofNullable(builder.getGRIN()).map(f->f.build()).orElse(null);
			this.oOLI = ofNullable(builder.getOOLI()).map(f->f.build()).orElse(null);
			this.pOTA = ofNullable(builder.getPOTA()).map(f->f.build()).orElse(null);
			this.dIRY = ofNullable(builder.getDIRY()).map(f->f.build()).orElse(null);
			this.fRST = ofNullable(builder.getFRST()).map(f->f.build()).orElse(null);
			this.sOFT = ofNullable(builder.getSOFT()).map(f->f.build()).orElse(null);
			this.lSTK = ofNullable(builder.getLSTK()).map(f->f.build()).orElse(null);
			this.gROS = ofNullable(builder.getGROS()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("SEAF")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SEAF")
		public AnnaDsbEmpty getSEAF() {
			return sEAF;
		}
		
		@Override
		@RosettaAttribute("GRIN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("GRIN")
		public AnnaDsbAdditionalSubProduct getGRIN() {
			return gRIN;
		}
		
		@Override
		@RosettaAttribute("OOLI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OOLI")
		public AnnaDsbAdditionalSubProduct getOOLI() {
			return oOLI;
		}
		
		@Override
		@RosettaAttribute("POTA")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("POTA")
		public AnnaDsbEmpty getPOTA() {
			return pOTA;
		}
		
		@Override
		@RosettaAttribute("DIRY")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DIRY")
		public AnnaDsbEmpty getDIRY() {
			return dIRY;
		}
		
		@Override
		@RosettaAttribute("FRST")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("FRST")
		public AnnaDsbEmpty getFRST() {
			return fRST;
		}
		
		@Override
		@RosettaAttribute("SOFT")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SOFT")
		public AnnaDsbAdditionalSubProduct getSOFT() {
			return sOFT;
		}
		
		@Override
		@RosettaAttribute("LSTK")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("LSTK")
		public AnnaDsbEmpty getLSTK() {
			return lSTK;
		}
		
		@Override
		@RosettaAttribute("GROS")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("GROS")
		public AnnaDsbAdditionalSubProduct getGROS() {
			return gROS;
		}
		
		@Override
		public AnnaDsbAGRI build() {
			return this;
		}
		
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder toBuilder() {
			AnnaDsbAGRI.AnnaDsbAGRIBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbAGRI.AnnaDsbAGRIBuilder builder) {
			ofNullable(getSEAF()).ifPresent(builder::setSEAF);
			ofNullable(getGRIN()).ifPresent(builder::setGRIN);
			ofNullable(getOOLI()).ifPresent(builder::setOOLI);
			ofNullable(getPOTA()).ifPresent(builder::setPOTA);
			ofNullable(getDIRY()).ifPresent(builder::setDIRY);
			ofNullable(getFRST()).ifPresent(builder::setFRST);
			ofNullable(getSOFT()).ifPresent(builder::setSOFT);
			ofNullable(getLSTK()).ifPresent(builder::setLSTK);
			ofNullable(getGROS()).ifPresent(builder::setGROS);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbAGRI _that = getType().cast(o);
		
			if (!Objects.equals(sEAF, _that.getSEAF())) return false;
			if (!Objects.equals(gRIN, _that.getGRIN())) return false;
			if (!Objects.equals(oOLI, _that.getOOLI())) return false;
			if (!Objects.equals(pOTA, _that.getPOTA())) return false;
			if (!Objects.equals(dIRY, _that.getDIRY())) return false;
			if (!Objects.equals(fRST, _that.getFRST())) return false;
			if (!Objects.equals(sOFT, _that.getSOFT())) return false;
			if (!Objects.equals(lSTK, _that.getLSTK())) return false;
			if (!Objects.equals(gROS, _that.getGROS())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sEAF != null ? sEAF.hashCode() : 0);
			_result = 31 * _result + (gRIN != null ? gRIN.hashCode() : 0);
			_result = 31 * _result + (oOLI != null ? oOLI.hashCode() : 0);
			_result = 31 * _result + (pOTA != null ? pOTA.hashCode() : 0);
			_result = 31 * _result + (dIRY != null ? dIRY.hashCode() : 0);
			_result = 31 * _result + (fRST != null ? fRST.hashCode() : 0);
			_result = 31 * _result + (sOFT != null ? sOFT.hashCode() : 0);
			_result = 31 * _result + (lSTK != null ? lSTK.hashCode() : 0);
			_result = 31 * _result + (gROS != null ? gROS.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbAGRI {" +
				"SEAF=" + this.sEAF + ", " +
				"GRIN=" + this.gRIN + ", " +
				"OOLI=" + this.oOLI + ", " +
				"POTA=" + this.pOTA + ", " +
				"DIRY=" + this.dIRY + ", " +
				"FRST=" + this.fRST + ", " +
				"SOFT=" + this.sOFT + ", " +
				"LSTK=" + this.lSTK + ", " +
				"GROS=" + this.gROS +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbAGRI  ***********************/
	class AnnaDsbAGRIBuilderImpl implements AnnaDsbAGRI.AnnaDsbAGRIBuilder {
	
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder sEAF;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder gRIN;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder oOLI;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder pOTA;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder dIRY;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder fRST;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder sOFT;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder lSTK;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder gROS;
		
		@Override
		@RosettaAttribute("SEAF")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SEAF")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getSEAF() {
			return sEAF;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateSEAF() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (sEAF!=null) {
				result = sEAF;
			}
			else {
				result = sEAF = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("GRIN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("GRIN")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getGRIN() {
			return gRIN;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateGRIN() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (gRIN!=null) {
				result = gRIN;
			}
			else {
				result = gRIN = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OOLI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OOLI")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOOLI() {
			return oOLI;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateOOLI() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (oOLI!=null) {
				result = oOLI;
			}
			else {
				result = oOLI = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("POTA")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("POTA")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getPOTA() {
			return pOTA;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreatePOTA() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (pOTA!=null) {
				result = pOTA;
			}
			else {
				result = pOTA = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("DIRY")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DIRY")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getDIRY() {
			return dIRY;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateDIRY() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (dIRY!=null) {
				result = dIRY;
			}
			else {
				result = dIRY = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("FRST")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("FRST")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getFRST() {
			return fRST;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateFRST() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (fRST!=null) {
				result = fRST;
			}
			else {
				result = fRST = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("SOFT")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SOFT")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getSOFT() {
			return sOFT;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateSOFT() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (sOFT!=null) {
				result = sOFT;
			}
			else {
				result = sOFT = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("LSTK")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("LSTK")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getLSTK() {
			return lSTK;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateLSTK() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (lSTK!=null) {
				result = lSTK;
			}
			else {
				result = lSTK = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("GROS")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("GROS")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getGROS() {
			return gROS;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateGROS() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (gROS!=null) {
				result = gROS;
			}
			else {
				result = gROS = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("SEAF")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SEAF")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder setSEAF(AnnaDsbEmpty _sEAF) {
			this.sEAF = _sEAF == null ? null : _sEAF.toBuilder();
			return this;
		}
		
		@RosettaAttribute("GRIN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("GRIN")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder setGRIN(AnnaDsbAdditionalSubProduct _gRIN) {
			this.gRIN = _gRIN == null ? null : _gRIN.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OOLI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OOLI")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder setOOLI(AnnaDsbAdditionalSubProduct _oOLI) {
			this.oOLI = _oOLI == null ? null : _oOLI.toBuilder();
			return this;
		}
		
		@RosettaAttribute("POTA")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("POTA")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder setPOTA(AnnaDsbEmpty _pOTA) {
			this.pOTA = _pOTA == null ? null : _pOTA.toBuilder();
			return this;
		}
		
		@RosettaAttribute("DIRY")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DIRY")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder setDIRY(AnnaDsbEmpty _dIRY) {
			this.dIRY = _dIRY == null ? null : _dIRY.toBuilder();
			return this;
		}
		
		@RosettaAttribute("FRST")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("FRST")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder setFRST(AnnaDsbEmpty _fRST) {
			this.fRST = _fRST == null ? null : _fRST.toBuilder();
			return this;
		}
		
		@RosettaAttribute("SOFT")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SOFT")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder setSOFT(AnnaDsbAdditionalSubProduct _sOFT) {
			this.sOFT = _sOFT == null ? null : _sOFT.toBuilder();
			return this;
		}
		
		@RosettaAttribute("LSTK")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("LSTK")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder setLSTK(AnnaDsbEmpty _lSTK) {
			this.lSTK = _lSTK == null ? null : _lSTK.toBuilder();
			return this;
		}
		
		@RosettaAttribute("GROS")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("GROS")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder setGROS(AnnaDsbAdditionalSubProduct _gROS) {
			this.gROS = _gROS == null ? null : _gROS.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbAGRI build() {
			return new AnnaDsbAGRI.AnnaDsbAGRIImpl(this);
		}
		
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder prune() {
			if (sEAF!=null && !sEAF.prune().hasData()) sEAF = null;
			if (gRIN!=null && !gRIN.prune().hasData()) gRIN = null;
			if (oOLI!=null && !oOLI.prune().hasData()) oOLI = null;
			if (pOTA!=null && !pOTA.prune().hasData()) pOTA = null;
			if (dIRY!=null && !dIRY.prune().hasData()) dIRY = null;
			if (fRST!=null && !fRST.prune().hasData()) fRST = null;
			if (sOFT!=null && !sOFT.prune().hasData()) sOFT = null;
			if (lSTK!=null && !lSTK.prune().hasData()) lSTK = null;
			if (gROS!=null && !gROS.prune().hasData()) gROS = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSEAF()!=null && getSEAF().hasData()) return true;
			if (getGRIN()!=null && getGRIN().hasData()) return true;
			if (getOOLI()!=null && getOOLI().hasData()) return true;
			if (getPOTA()!=null && getPOTA().hasData()) return true;
			if (getDIRY()!=null && getDIRY().hasData()) return true;
			if (getFRST()!=null && getFRST().hasData()) return true;
			if (getSOFT()!=null && getSOFT().hasData()) return true;
			if (getLSTK()!=null && getLSTK().hasData()) return true;
			if (getGROS()!=null && getGROS().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbAGRI.AnnaDsbAGRIBuilder o = (AnnaDsbAGRI.AnnaDsbAGRIBuilder) other;
			
			merger.mergeRosetta(getSEAF(), o.getSEAF(), this::setSEAF);
			merger.mergeRosetta(getGRIN(), o.getGRIN(), this::setGRIN);
			merger.mergeRosetta(getOOLI(), o.getOOLI(), this::setOOLI);
			merger.mergeRosetta(getPOTA(), o.getPOTA(), this::setPOTA);
			merger.mergeRosetta(getDIRY(), o.getDIRY(), this::setDIRY);
			merger.mergeRosetta(getFRST(), o.getFRST(), this::setFRST);
			merger.mergeRosetta(getSOFT(), o.getSOFT(), this::setSOFT);
			merger.mergeRosetta(getLSTK(), o.getLSTK(), this::setLSTK);
			merger.mergeRosetta(getGROS(), o.getGROS(), this::setGROS);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbAGRI _that = getType().cast(o);
		
			if (!Objects.equals(sEAF, _that.getSEAF())) return false;
			if (!Objects.equals(gRIN, _that.getGRIN())) return false;
			if (!Objects.equals(oOLI, _that.getOOLI())) return false;
			if (!Objects.equals(pOTA, _that.getPOTA())) return false;
			if (!Objects.equals(dIRY, _that.getDIRY())) return false;
			if (!Objects.equals(fRST, _that.getFRST())) return false;
			if (!Objects.equals(sOFT, _that.getSOFT())) return false;
			if (!Objects.equals(lSTK, _that.getLSTK())) return false;
			if (!Objects.equals(gROS, _that.getGROS())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sEAF != null ? sEAF.hashCode() : 0);
			_result = 31 * _result + (gRIN != null ? gRIN.hashCode() : 0);
			_result = 31 * _result + (oOLI != null ? oOLI.hashCode() : 0);
			_result = 31 * _result + (pOTA != null ? pOTA.hashCode() : 0);
			_result = 31 * _result + (dIRY != null ? dIRY.hashCode() : 0);
			_result = 31 * _result + (fRST != null ? fRST.hashCode() : 0);
			_result = 31 * _result + (sOFT != null ? sOFT.hashCode() : 0);
			_result = 31 * _result + (lSTK != null ? lSTK.hashCode() : 0);
			_result = 31 * _result + (gROS != null ? gROS.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbAGRIBuilder {" +
				"SEAF=" + this.sEAF + ", " +
				"GRIN=" + this.gRIN + ", " +
				"OOLI=" + this.oOLI + ", " +
				"POTA=" + this.pOTA + ", " +
				"DIRY=" + this.dIRY + ", " +
				"FRST=" + this.fRST + ", " +
				"SOFT=" + this.sOFT + ", " +
				"LSTK=" + this.lSTK + ", " +
				"GROS=" + this.gROS +
			'}';
		}
	}
}
