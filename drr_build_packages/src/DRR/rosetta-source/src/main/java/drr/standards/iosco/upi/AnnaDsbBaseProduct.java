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
import drr.standards.iosco.upi.meta.AnnaDsbBaseProductMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbBaseProduct", builder=AnnaDsbBaseProduct.AnnaDsbBaseProductBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbBaseProduct", model="drr", builder=AnnaDsbBaseProduct.AnnaDsbBaseProductBuilderImpl.class, version="7.7.0")
public interface AnnaDsbBaseProduct extends RosettaModelObject {

	AnnaDsbBaseProductMeta metaData = new AnnaDsbBaseProductMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbAGRI getAGRI();
	AnnaDsbENVR getENVR();
	AnnaDsbFRTL getFRTL();
	AnnaDsbOTHC getOTHC();
	AnnaDsbEmpty getINFL();
	AnnaDsbPOLY getPOLY();
	AnnaDsbEmpty getOTHR();
	AnnaDsbEmpty getMCEX();
	AnnaDsbNRGY getNRGY();
	AnnaDsbINDP getINDP();
	AnnaDsbEmpty getOEST();
	AnnaDsbMETL getMETL();
	AnnaDsbPAPR getPAPR();
	AnnaDsbFRGT getFRGT();

	/*********************** Build Methods  ***********************/
	AnnaDsbBaseProduct build();
	
	AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder toBuilder();
	
	static AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder builder() {
		return new AnnaDsbBaseProduct.AnnaDsbBaseProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbBaseProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbBaseProduct> getType() {
		return AnnaDsbBaseProduct.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("AGRI"), processor, AnnaDsbAGRI.class, getAGRI());
		processRosetta(path.newSubPath("ENVR"), processor, AnnaDsbENVR.class, getENVR());
		processRosetta(path.newSubPath("FRTL"), processor, AnnaDsbFRTL.class, getFRTL());
		processRosetta(path.newSubPath("OTHC"), processor, AnnaDsbOTHC.class, getOTHC());
		processRosetta(path.newSubPath("INFL"), processor, AnnaDsbEmpty.class, getINFL());
		processRosetta(path.newSubPath("POLY"), processor, AnnaDsbPOLY.class, getPOLY());
		processRosetta(path.newSubPath("OTHR"), processor, AnnaDsbEmpty.class, getOTHR());
		processRosetta(path.newSubPath("MCEX"), processor, AnnaDsbEmpty.class, getMCEX());
		processRosetta(path.newSubPath("NRGY"), processor, AnnaDsbNRGY.class, getNRGY());
		processRosetta(path.newSubPath("INDP"), processor, AnnaDsbINDP.class, getINDP());
		processRosetta(path.newSubPath("OEST"), processor, AnnaDsbEmpty.class, getOEST());
		processRosetta(path.newSubPath("METL"), processor, AnnaDsbMETL.class, getMETL());
		processRosetta(path.newSubPath("PAPR"), processor, AnnaDsbPAPR.class, getPAPR());
		processRosetta(path.newSubPath("FRGT"), processor, AnnaDsbFRGT.class, getFRGT());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbBaseProductBuilder extends AnnaDsbBaseProduct, RosettaModelObjectBuilder {
		AnnaDsbAGRI.AnnaDsbAGRIBuilder getOrCreateAGRI();
		@Override
		AnnaDsbAGRI.AnnaDsbAGRIBuilder getAGRI();
		AnnaDsbENVR.AnnaDsbENVRBuilder getOrCreateENVR();
		@Override
		AnnaDsbENVR.AnnaDsbENVRBuilder getENVR();
		AnnaDsbFRTL.AnnaDsbFRTLBuilder getOrCreateFRTL();
		@Override
		AnnaDsbFRTL.AnnaDsbFRTLBuilder getFRTL();
		AnnaDsbOTHC.AnnaDsbOTHCBuilder getOrCreateOTHC();
		@Override
		AnnaDsbOTHC.AnnaDsbOTHCBuilder getOTHC();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateINFL();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getINFL();
		AnnaDsbPOLY.AnnaDsbPOLYBuilder getOrCreatePOLY();
		@Override
		AnnaDsbPOLY.AnnaDsbPOLYBuilder getPOLY();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateOTHR();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOTHR();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateMCEX();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getMCEX();
		AnnaDsbNRGY.AnnaDsbNRGYBuilder getOrCreateNRGY();
		@Override
		AnnaDsbNRGY.AnnaDsbNRGYBuilder getNRGY();
		AnnaDsbINDP.AnnaDsbINDPBuilder getOrCreateINDP();
		@Override
		AnnaDsbINDP.AnnaDsbINDPBuilder getINDP();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateOEST();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOEST();
		AnnaDsbMETL.AnnaDsbMETLBuilder getOrCreateMETL();
		@Override
		AnnaDsbMETL.AnnaDsbMETLBuilder getMETL();
		AnnaDsbPAPR.AnnaDsbPAPRBuilder getOrCreatePAPR();
		@Override
		AnnaDsbPAPR.AnnaDsbPAPRBuilder getPAPR();
		AnnaDsbFRGT.AnnaDsbFRGTBuilder getOrCreateFRGT();
		@Override
		AnnaDsbFRGT.AnnaDsbFRGTBuilder getFRGT();
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setAGRI(AnnaDsbAGRI AGRI);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setENVR(AnnaDsbENVR ENVR);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setFRTL(AnnaDsbFRTL FRTL);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setOTHC(AnnaDsbOTHC OTHC);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setINFL(AnnaDsbEmpty INFL);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setPOLY(AnnaDsbPOLY POLY);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setOTHR(AnnaDsbEmpty OTHR);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setMCEX(AnnaDsbEmpty MCEX);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setNRGY(AnnaDsbNRGY NRGY);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setINDP(AnnaDsbINDP INDP);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setOEST(AnnaDsbEmpty OEST);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setMETL(AnnaDsbMETL METL);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setPAPR(AnnaDsbPAPR PAPR);
		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setFRGT(AnnaDsbFRGT FRGT);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("AGRI"), processor, AnnaDsbAGRI.AnnaDsbAGRIBuilder.class, getAGRI());
			processRosetta(path.newSubPath("ENVR"), processor, AnnaDsbENVR.AnnaDsbENVRBuilder.class, getENVR());
			processRosetta(path.newSubPath("FRTL"), processor, AnnaDsbFRTL.AnnaDsbFRTLBuilder.class, getFRTL());
			processRosetta(path.newSubPath("OTHC"), processor, AnnaDsbOTHC.AnnaDsbOTHCBuilder.class, getOTHC());
			processRosetta(path.newSubPath("INFL"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getINFL());
			processRosetta(path.newSubPath("POLY"), processor, AnnaDsbPOLY.AnnaDsbPOLYBuilder.class, getPOLY());
			processRosetta(path.newSubPath("OTHR"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getOTHR());
			processRosetta(path.newSubPath("MCEX"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getMCEX());
			processRosetta(path.newSubPath("NRGY"), processor, AnnaDsbNRGY.AnnaDsbNRGYBuilder.class, getNRGY());
			processRosetta(path.newSubPath("INDP"), processor, AnnaDsbINDP.AnnaDsbINDPBuilder.class, getINDP());
			processRosetta(path.newSubPath("OEST"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getOEST());
			processRosetta(path.newSubPath("METL"), processor, AnnaDsbMETL.AnnaDsbMETLBuilder.class, getMETL());
			processRosetta(path.newSubPath("PAPR"), processor, AnnaDsbPAPR.AnnaDsbPAPRBuilder.class, getPAPR());
			processRosetta(path.newSubPath("FRGT"), processor, AnnaDsbFRGT.AnnaDsbFRGTBuilder.class, getFRGT());
		}
		

		AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbBaseProduct  ***********************/
	class AnnaDsbBaseProductImpl implements AnnaDsbBaseProduct {
		private final AnnaDsbAGRI aGRI;
		private final AnnaDsbENVR eNVR;
		private final AnnaDsbFRTL fRTL;
		private final AnnaDsbOTHC oTHC;
		private final AnnaDsbEmpty iNFL;
		private final AnnaDsbPOLY pOLY;
		private final AnnaDsbEmpty oTHR;
		private final AnnaDsbEmpty mCEX;
		private final AnnaDsbNRGY nRGY;
		private final AnnaDsbINDP iNDP;
		private final AnnaDsbEmpty oEST;
		private final AnnaDsbMETL mETL;
		private final AnnaDsbPAPR pAPR;
		private final AnnaDsbFRGT fRGT;
		
		protected AnnaDsbBaseProductImpl(AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder builder) {
			this.aGRI = ofNullable(builder.getAGRI()).map(f->f.build()).orElse(null);
			this.eNVR = ofNullable(builder.getENVR()).map(f->f.build()).orElse(null);
			this.fRTL = ofNullable(builder.getFRTL()).map(f->f.build()).orElse(null);
			this.oTHC = ofNullable(builder.getOTHC()).map(f->f.build()).orElse(null);
			this.iNFL = ofNullable(builder.getINFL()).map(f->f.build()).orElse(null);
			this.pOLY = ofNullable(builder.getPOLY()).map(f->f.build()).orElse(null);
			this.oTHR = ofNullable(builder.getOTHR()).map(f->f.build()).orElse(null);
			this.mCEX = ofNullable(builder.getMCEX()).map(f->f.build()).orElse(null);
			this.nRGY = ofNullable(builder.getNRGY()).map(f->f.build()).orElse(null);
			this.iNDP = ofNullable(builder.getINDP()).map(f->f.build()).orElse(null);
			this.oEST = ofNullable(builder.getOEST()).map(f->f.build()).orElse(null);
			this.mETL = ofNullable(builder.getMETL()).map(f->f.build()).orElse(null);
			this.pAPR = ofNullable(builder.getPAPR()).map(f->f.build()).orElse(null);
			this.fRGT = ofNullable(builder.getFRGT()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("AGRI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("AGRI")
		public AnnaDsbAGRI getAGRI() {
			return aGRI;
		}
		
		@Override
		@RosettaAttribute("ENVR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ENVR")
		public AnnaDsbENVR getENVR() {
			return eNVR;
		}
		
		@Override
		@RosettaAttribute("FRTL")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("FRTL")
		public AnnaDsbFRTL getFRTL() {
			return fRTL;
		}
		
		@Override
		@RosettaAttribute("OTHC")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OTHC")
		public AnnaDsbOTHC getOTHC() {
			return oTHC;
		}
		
		@Override
		@RosettaAttribute("INFL")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("INFL")
		public AnnaDsbEmpty getINFL() {
			return iNFL;
		}
		
		@Override
		@RosettaAttribute("POLY")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("POLY")
		public AnnaDsbPOLY getPOLY() {
			return pOLY;
		}
		
		@Override
		@RosettaAttribute("OTHR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OTHR")
		public AnnaDsbEmpty getOTHR() {
			return oTHR;
		}
		
		@Override
		@RosettaAttribute("MCEX")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("MCEX")
		public AnnaDsbEmpty getMCEX() {
			return mCEX;
		}
		
		@Override
		@RosettaAttribute("NRGY")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NRGY")
		public AnnaDsbNRGY getNRGY() {
			return nRGY;
		}
		
		@Override
		@RosettaAttribute("INDP")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("INDP")
		public AnnaDsbINDP getINDP() {
			return iNDP;
		}
		
		@Override
		@RosettaAttribute("OEST")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OEST")
		public AnnaDsbEmpty getOEST() {
			return oEST;
		}
		
		@Override
		@RosettaAttribute("METL")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("METL")
		public AnnaDsbMETL getMETL() {
			return mETL;
		}
		
		@Override
		@RosettaAttribute("PAPR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PAPR")
		public AnnaDsbPAPR getPAPR() {
			return pAPR;
		}
		
		@Override
		@RosettaAttribute("FRGT")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("FRGT")
		public AnnaDsbFRGT getFRGT() {
			return fRGT;
		}
		
		@Override
		public AnnaDsbBaseProduct build() {
			return this;
		}
		
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder toBuilder() {
			AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder builder) {
			ofNullable(getAGRI()).ifPresent(builder::setAGRI);
			ofNullable(getENVR()).ifPresent(builder::setENVR);
			ofNullable(getFRTL()).ifPresent(builder::setFRTL);
			ofNullable(getOTHC()).ifPresent(builder::setOTHC);
			ofNullable(getINFL()).ifPresent(builder::setINFL);
			ofNullable(getPOLY()).ifPresent(builder::setPOLY);
			ofNullable(getOTHR()).ifPresent(builder::setOTHR);
			ofNullable(getMCEX()).ifPresent(builder::setMCEX);
			ofNullable(getNRGY()).ifPresent(builder::setNRGY);
			ofNullable(getINDP()).ifPresent(builder::setINDP);
			ofNullable(getOEST()).ifPresent(builder::setOEST);
			ofNullable(getMETL()).ifPresent(builder::setMETL);
			ofNullable(getPAPR()).ifPresent(builder::setPAPR);
			ofNullable(getFRGT()).ifPresent(builder::setFRGT);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbBaseProduct _that = getType().cast(o);
		
			if (!Objects.equals(aGRI, _that.getAGRI())) return false;
			if (!Objects.equals(eNVR, _that.getENVR())) return false;
			if (!Objects.equals(fRTL, _that.getFRTL())) return false;
			if (!Objects.equals(oTHC, _that.getOTHC())) return false;
			if (!Objects.equals(iNFL, _that.getINFL())) return false;
			if (!Objects.equals(pOLY, _that.getPOLY())) return false;
			if (!Objects.equals(oTHR, _that.getOTHR())) return false;
			if (!Objects.equals(mCEX, _that.getMCEX())) return false;
			if (!Objects.equals(nRGY, _that.getNRGY())) return false;
			if (!Objects.equals(iNDP, _that.getINDP())) return false;
			if (!Objects.equals(oEST, _that.getOEST())) return false;
			if (!Objects.equals(mETL, _that.getMETL())) return false;
			if (!Objects.equals(pAPR, _that.getPAPR())) return false;
			if (!Objects.equals(fRGT, _that.getFRGT())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (aGRI != null ? aGRI.hashCode() : 0);
			_result = 31 * _result + (eNVR != null ? eNVR.hashCode() : 0);
			_result = 31 * _result + (fRTL != null ? fRTL.hashCode() : 0);
			_result = 31 * _result + (oTHC != null ? oTHC.hashCode() : 0);
			_result = 31 * _result + (iNFL != null ? iNFL.hashCode() : 0);
			_result = 31 * _result + (pOLY != null ? pOLY.hashCode() : 0);
			_result = 31 * _result + (oTHR != null ? oTHR.hashCode() : 0);
			_result = 31 * _result + (mCEX != null ? mCEX.hashCode() : 0);
			_result = 31 * _result + (nRGY != null ? nRGY.hashCode() : 0);
			_result = 31 * _result + (iNDP != null ? iNDP.hashCode() : 0);
			_result = 31 * _result + (oEST != null ? oEST.hashCode() : 0);
			_result = 31 * _result + (mETL != null ? mETL.hashCode() : 0);
			_result = 31 * _result + (pAPR != null ? pAPR.hashCode() : 0);
			_result = 31 * _result + (fRGT != null ? fRGT.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbBaseProduct {" +
				"AGRI=" + this.aGRI + ", " +
				"ENVR=" + this.eNVR + ", " +
				"FRTL=" + this.fRTL + ", " +
				"OTHC=" + this.oTHC + ", " +
				"INFL=" + this.iNFL + ", " +
				"POLY=" + this.pOLY + ", " +
				"OTHR=" + this.oTHR + ", " +
				"MCEX=" + this.mCEX + ", " +
				"NRGY=" + this.nRGY + ", " +
				"INDP=" + this.iNDP + ", " +
				"OEST=" + this.oEST + ", " +
				"METL=" + this.mETL + ", " +
				"PAPR=" + this.pAPR + ", " +
				"FRGT=" + this.fRGT +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbBaseProduct  ***********************/
	class AnnaDsbBaseProductBuilderImpl implements AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder {
	
		protected AnnaDsbAGRI.AnnaDsbAGRIBuilder aGRI;
		protected AnnaDsbENVR.AnnaDsbENVRBuilder eNVR;
		protected AnnaDsbFRTL.AnnaDsbFRTLBuilder fRTL;
		protected AnnaDsbOTHC.AnnaDsbOTHCBuilder oTHC;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder iNFL;
		protected AnnaDsbPOLY.AnnaDsbPOLYBuilder pOLY;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder oTHR;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder mCEX;
		protected AnnaDsbNRGY.AnnaDsbNRGYBuilder nRGY;
		protected AnnaDsbINDP.AnnaDsbINDPBuilder iNDP;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder oEST;
		protected AnnaDsbMETL.AnnaDsbMETLBuilder mETL;
		protected AnnaDsbPAPR.AnnaDsbPAPRBuilder pAPR;
		protected AnnaDsbFRGT.AnnaDsbFRGTBuilder fRGT;
		
		@Override
		@RosettaAttribute("AGRI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("AGRI")
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder getAGRI() {
			return aGRI;
		}
		
		@Override
		public AnnaDsbAGRI.AnnaDsbAGRIBuilder getOrCreateAGRI() {
			AnnaDsbAGRI.AnnaDsbAGRIBuilder result;
			if (aGRI!=null) {
				result = aGRI;
			}
			else {
				result = aGRI = AnnaDsbAGRI.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ENVR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ENVR")
		public AnnaDsbENVR.AnnaDsbENVRBuilder getENVR() {
			return eNVR;
		}
		
		@Override
		public AnnaDsbENVR.AnnaDsbENVRBuilder getOrCreateENVR() {
			AnnaDsbENVR.AnnaDsbENVRBuilder result;
			if (eNVR!=null) {
				result = eNVR;
			}
			else {
				result = eNVR = AnnaDsbENVR.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("FRTL")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("FRTL")
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder getFRTL() {
			return fRTL;
		}
		
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder getOrCreateFRTL() {
			AnnaDsbFRTL.AnnaDsbFRTLBuilder result;
			if (fRTL!=null) {
				result = fRTL;
			}
			else {
				result = fRTL = AnnaDsbFRTL.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OTHC")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OTHC")
		public AnnaDsbOTHC.AnnaDsbOTHCBuilder getOTHC() {
			return oTHC;
		}
		
		@Override
		public AnnaDsbOTHC.AnnaDsbOTHCBuilder getOrCreateOTHC() {
			AnnaDsbOTHC.AnnaDsbOTHCBuilder result;
			if (oTHC!=null) {
				result = oTHC;
			}
			else {
				result = oTHC = AnnaDsbOTHC.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("INFL")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("INFL")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getINFL() {
			return iNFL;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateINFL() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (iNFL!=null) {
				result = iNFL;
			}
			else {
				result = iNFL = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("POLY")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("POLY")
		public AnnaDsbPOLY.AnnaDsbPOLYBuilder getPOLY() {
			return pOLY;
		}
		
		@Override
		public AnnaDsbPOLY.AnnaDsbPOLYBuilder getOrCreatePOLY() {
			AnnaDsbPOLY.AnnaDsbPOLYBuilder result;
			if (pOLY!=null) {
				result = pOLY;
			}
			else {
				result = pOLY = AnnaDsbPOLY.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OTHR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OTHR")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOTHR() {
			return oTHR;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateOTHR() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (oTHR!=null) {
				result = oTHR;
			}
			else {
				result = oTHR = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("MCEX")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("MCEX")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getMCEX() {
			return mCEX;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateMCEX() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (mCEX!=null) {
				result = mCEX;
			}
			else {
				result = mCEX = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("NRGY")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NRGY")
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder getNRGY() {
			return nRGY;
		}
		
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder getOrCreateNRGY() {
			AnnaDsbNRGY.AnnaDsbNRGYBuilder result;
			if (nRGY!=null) {
				result = nRGY;
			}
			else {
				result = nRGY = AnnaDsbNRGY.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("INDP")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("INDP")
		public AnnaDsbINDP.AnnaDsbINDPBuilder getINDP() {
			return iNDP;
		}
		
		@Override
		public AnnaDsbINDP.AnnaDsbINDPBuilder getOrCreateINDP() {
			AnnaDsbINDP.AnnaDsbINDPBuilder result;
			if (iNDP!=null) {
				result = iNDP;
			}
			else {
				result = iNDP = AnnaDsbINDP.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OEST")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OEST")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOEST() {
			return oEST;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateOEST() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (oEST!=null) {
				result = oEST;
			}
			else {
				result = oEST = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("METL")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("METL")
		public AnnaDsbMETL.AnnaDsbMETLBuilder getMETL() {
			return mETL;
		}
		
		@Override
		public AnnaDsbMETL.AnnaDsbMETLBuilder getOrCreateMETL() {
			AnnaDsbMETL.AnnaDsbMETLBuilder result;
			if (mETL!=null) {
				result = mETL;
			}
			else {
				result = mETL = AnnaDsbMETL.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("PAPR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PAPR")
		public AnnaDsbPAPR.AnnaDsbPAPRBuilder getPAPR() {
			return pAPR;
		}
		
		@Override
		public AnnaDsbPAPR.AnnaDsbPAPRBuilder getOrCreatePAPR() {
			AnnaDsbPAPR.AnnaDsbPAPRBuilder result;
			if (pAPR!=null) {
				result = pAPR;
			}
			else {
				result = pAPR = AnnaDsbPAPR.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("FRGT")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("FRGT")
		public AnnaDsbFRGT.AnnaDsbFRGTBuilder getFRGT() {
			return fRGT;
		}
		
		@Override
		public AnnaDsbFRGT.AnnaDsbFRGTBuilder getOrCreateFRGT() {
			AnnaDsbFRGT.AnnaDsbFRGTBuilder result;
			if (fRGT!=null) {
				result = fRGT;
			}
			else {
				result = fRGT = AnnaDsbFRGT.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("AGRI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("AGRI")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setAGRI(AnnaDsbAGRI _aGRI) {
			this.aGRI = _aGRI == null ? null : _aGRI.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ENVR")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ENVR")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setENVR(AnnaDsbENVR _eNVR) {
			this.eNVR = _eNVR == null ? null : _eNVR.toBuilder();
			return this;
		}
		
		@RosettaAttribute("FRTL")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("FRTL")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setFRTL(AnnaDsbFRTL _fRTL) {
			this.fRTL = _fRTL == null ? null : _fRTL.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OTHC")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OTHC")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setOTHC(AnnaDsbOTHC _oTHC) {
			this.oTHC = _oTHC == null ? null : _oTHC.toBuilder();
			return this;
		}
		
		@RosettaAttribute("INFL")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("INFL")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setINFL(AnnaDsbEmpty _iNFL) {
			this.iNFL = _iNFL == null ? null : _iNFL.toBuilder();
			return this;
		}
		
		@RosettaAttribute("POLY")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("POLY")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setPOLY(AnnaDsbPOLY _pOLY) {
			this.pOLY = _pOLY == null ? null : _pOLY.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OTHR")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OTHR")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setOTHR(AnnaDsbEmpty _oTHR) {
			this.oTHR = _oTHR == null ? null : _oTHR.toBuilder();
			return this;
		}
		
		@RosettaAttribute("MCEX")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("MCEX")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setMCEX(AnnaDsbEmpty _mCEX) {
			this.mCEX = _mCEX == null ? null : _mCEX.toBuilder();
			return this;
		}
		
		@RosettaAttribute("NRGY")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NRGY")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setNRGY(AnnaDsbNRGY _nRGY) {
			this.nRGY = _nRGY == null ? null : _nRGY.toBuilder();
			return this;
		}
		
		@RosettaAttribute("INDP")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("INDP")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setINDP(AnnaDsbINDP _iNDP) {
			this.iNDP = _iNDP == null ? null : _iNDP.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OEST")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OEST")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setOEST(AnnaDsbEmpty _oEST) {
			this.oEST = _oEST == null ? null : _oEST.toBuilder();
			return this;
		}
		
		@RosettaAttribute("METL")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("METL")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setMETL(AnnaDsbMETL _mETL) {
			this.mETL = _mETL == null ? null : _mETL.toBuilder();
			return this;
		}
		
		@RosettaAttribute("PAPR")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("PAPR")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setPAPR(AnnaDsbPAPR _pAPR) {
			this.pAPR = _pAPR == null ? null : _pAPR.toBuilder();
			return this;
		}
		
		@RosettaAttribute("FRGT")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("FRGT")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder setFRGT(AnnaDsbFRGT _fRGT) {
			this.fRGT = _fRGT == null ? null : _fRGT.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbBaseProduct build() {
			return new AnnaDsbBaseProduct.AnnaDsbBaseProductImpl(this);
		}
		
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder prune() {
			if (aGRI!=null && !aGRI.prune().hasData()) aGRI = null;
			if (eNVR!=null && !eNVR.prune().hasData()) eNVR = null;
			if (fRTL!=null && !fRTL.prune().hasData()) fRTL = null;
			if (oTHC!=null && !oTHC.prune().hasData()) oTHC = null;
			if (iNFL!=null && !iNFL.prune().hasData()) iNFL = null;
			if (pOLY!=null && !pOLY.prune().hasData()) pOLY = null;
			if (oTHR!=null && !oTHR.prune().hasData()) oTHR = null;
			if (mCEX!=null && !mCEX.prune().hasData()) mCEX = null;
			if (nRGY!=null && !nRGY.prune().hasData()) nRGY = null;
			if (iNDP!=null && !iNDP.prune().hasData()) iNDP = null;
			if (oEST!=null && !oEST.prune().hasData()) oEST = null;
			if (mETL!=null && !mETL.prune().hasData()) mETL = null;
			if (pAPR!=null && !pAPR.prune().hasData()) pAPR = null;
			if (fRGT!=null && !fRGT.prune().hasData()) fRGT = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAGRI()!=null && getAGRI().hasData()) return true;
			if (getENVR()!=null && getENVR().hasData()) return true;
			if (getFRTL()!=null && getFRTL().hasData()) return true;
			if (getOTHC()!=null && getOTHC().hasData()) return true;
			if (getINFL()!=null && getINFL().hasData()) return true;
			if (getPOLY()!=null && getPOLY().hasData()) return true;
			if (getOTHR()!=null && getOTHR().hasData()) return true;
			if (getMCEX()!=null && getMCEX().hasData()) return true;
			if (getNRGY()!=null && getNRGY().hasData()) return true;
			if (getINDP()!=null && getINDP().hasData()) return true;
			if (getOEST()!=null && getOEST().hasData()) return true;
			if (getMETL()!=null && getMETL().hasData()) return true;
			if (getPAPR()!=null && getPAPR().hasData()) return true;
			if (getFRGT()!=null && getFRGT().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder o = (AnnaDsbBaseProduct.AnnaDsbBaseProductBuilder) other;
			
			merger.mergeRosetta(getAGRI(), o.getAGRI(), this::setAGRI);
			merger.mergeRosetta(getENVR(), o.getENVR(), this::setENVR);
			merger.mergeRosetta(getFRTL(), o.getFRTL(), this::setFRTL);
			merger.mergeRosetta(getOTHC(), o.getOTHC(), this::setOTHC);
			merger.mergeRosetta(getINFL(), o.getINFL(), this::setINFL);
			merger.mergeRosetta(getPOLY(), o.getPOLY(), this::setPOLY);
			merger.mergeRosetta(getOTHR(), o.getOTHR(), this::setOTHR);
			merger.mergeRosetta(getMCEX(), o.getMCEX(), this::setMCEX);
			merger.mergeRosetta(getNRGY(), o.getNRGY(), this::setNRGY);
			merger.mergeRosetta(getINDP(), o.getINDP(), this::setINDP);
			merger.mergeRosetta(getOEST(), o.getOEST(), this::setOEST);
			merger.mergeRosetta(getMETL(), o.getMETL(), this::setMETL);
			merger.mergeRosetta(getPAPR(), o.getPAPR(), this::setPAPR);
			merger.mergeRosetta(getFRGT(), o.getFRGT(), this::setFRGT);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbBaseProduct _that = getType().cast(o);
		
			if (!Objects.equals(aGRI, _that.getAGRI())) return false;
			if (!Objects.equals(eNVR, _that.getENVR())) return false;
			if (!Objects.equals(fRTL, _that.getFRTL())) return false;
			if (!Objects.equals(oTHC, _that.getOTHC())) return false;
			if (!Objects.equals(iNFL, _that.getINFL())) return false;
			if (!Objects.equals(pOLY, _that.getPOLY())) return false;
			if (!Objects.equals(oTHR, _that.getOTHR())) return false;
			if (!Objects.equals(mCEX, _that.getMCEX())) return false;
			if (!Objects.equals(nRGY, _that.getNRGY())) return false;
			if (!Objects.equals(iNDP, _that.getINDP())) return false;
			if (!Objects.equals(oEST, _that.getOEST())) return false;
			if (!Objects.equals(mETL, _that.getMETL())) return false;
			if (!Objects.equals(pAPR, _that.getPAPR())) return false;
			if (!Objects.equals(fRGT, _that.getFRGT())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (aGRI != null ? aGRI.hashCode() : 0);
			_result = 31 * _result + (eNVR != null ? eNVR.hashCode() : 0);
			_result = 31 * _result + (fRTL != null ? fRTL.hashCode() : 0);
			_result = 31 * _result + (oTHC != null ? oTHC.hashCode() : 0);
			_result = 31 * _result + (iNFL != null ? iNFL.hashCode() : 0);
			_result = 31 * _result + (pOLY != null ? pOLY.hashCode() : 0);
			_result = 31 * _result + (oTHR != null ? oTHR.hashCode() : 0);
			_result = 31 * _result + (mCEX != null ? mCEX.hashCode() : 0);
			_result = 31 * _result + (nRGY != null ? nRGY.hashCode() : 0);
			_result = 31 * _result + (iNDP != null ? iNDP.hashCode() : 0);
			_result = 31 * _result + (oEST != null ? oEST.hashCode() : 0);
			_result = 31 * _result + (mETL != null ? mETL.hashCode() : 0);
			_result = 31 * _result + (pAPR != null ? pAPR.hashCode() : 0);
			_result = 31 * _result + (fRGT != null ? fRGT.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbBaseProductBuilder {" +
				"AGRI=" + this.aGRI + ", " +
				"ENVR=" + this.eNVR + ", " +
				"FRTL=" + this.fRTL + ", " +
				"OTHC=" + this.oTHC + ", " +
				"INFL=" + this.iNFL + ", " +
				"POLY=" + this.pOLY + ", " +
				"OTHR=" + this.oTHR + ", " +
				"MCEX=" + this.mCEX + ", " +
				"NRGY=" + this.nRGY + ", " +
				"INDP=" + this.iNDP + ", " +
				"OEST=" + this.oEST + ", " +
				"METL=" + this.mETL + ", " +
				"PAPR=" + this.pAPR + ", " +
				"FRGT=" + this.fRGT +
			'}';
		}
	}
}
