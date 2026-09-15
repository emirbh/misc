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
import drr.standards.iosco.upi.meta.AnnaDsbNRGYMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbNRGY", builder=AnnaDsbNRGY.AnnaDsbNRGYBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbNRGY", model="drr", builder=AnnaDsbNRGY.AnnaDsbNRGYBuilderImpl.class, version="7.7.0")
public interface AnnaDsbNRGY extends RosettaModelObject {

	AnnaDsbNRGYMeta metaData = new AnnaDsbNRGYMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbEmpty getRNNG();
	AnnaDsbEmpty getLGHT();
	AnnaDsbAdditionalSubProduct getELEC();
	AnnaDsbEmpty getDIST();
	AnnaDsbEmpty getCOAL();
	AnnaDsbEmpty getINRG();
	AnnaDsbAdditionalSubProduct getOILP();
	AnnaDsbAdditionalSubProduct getNGAS();

	/*********************** Build Methods  ***********************/
	AnnaDsbNRGY build();
	
	AnnaDsbNRGY.AnnaDsbNRGYBuilder toBuilder();
	
	static AnnaDsbNRGY.AnnaDsbNRGYBuilder builder() {
		return new AnnaDsbNRGY.AnnaDsbNRGYBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbNRGY> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbNRGY> getType() {
		return AnnaDsbNRGY.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("RNNG"), processor, AnnaDsbEmpty.class, getRNNG());
		processRosetta(path.newSubPath("LGHT"), processor, AnnaDsbEmpty.class, getLGHT());
		processRosetta(path.newSubPath("ELEC"), processor, AnnaDsbAdditionalSubProduct.class, getELEC());
		processRosetta(path.newSubPath("DIST"), processor, AnnaDsbEmpty.class, getDIST());
		processRosetta(path.newSubPath("COAL"), processor, AnnaDsbEmpty.class, getCOAL());
		processRosetta(path.newSubPath("INRG"), processor, AnnaDsbEmpty.class, getINRG());
		processRosetta(path.newSubPath("OILP"), processor, AnnaDsbAdditionalSubProduct.class, getOILP());
		processRosetta(path.newSubPath("NGAS"), processor, AnnaDsbAdditionalSubProduct.class, getNGAS());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbNRGYBuilder extends AnnaDsbNRGY, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateRNNG();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getRNNG();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateLGHT();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getLGHT();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateELEC();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getELEC();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateDIST();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getDIST();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateCOAL();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getCOAL();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateINRG();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getINRG();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateOILP();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOILP();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateNGAS();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getNGAS();
		AnnaDsbNRGY.AnnaDsbNRGYBuilder setRNNG(AnnaDsbEmpty RNNG);
		AnnaDsbNRGY.AnnaDsbNRGYBuilder setLGHT(AnnaDsbEmpty LGHT);
		AnnaDsbNRGY.AnnaDsbNRGYBuilder setELEC(AnnaDsbAdditionalSubProduct ELEC);
		AnnaDsbNRGY.AnnaDsbNRGYBuilder setDIST(AnnaDsbEmpty DIST);
		AnnaDsbNRGY.AnnaDsbNRGYBuilder setCOAL(AnnaDsbEmpty COAL);
		AnnaDsbNRGY.AnnaDsbNRGYBuilder setINRG(AnnaDsbEmpty INRG);
		AnnaDsbNRGY.AnnaDsbNRGYBuilder setOILP(AnnaDsbAdditionalSubProduct OILP);
		AnnaDsbNRGY.AnnaDsbNRGYBuilder setNGAS(AnnaDsbAdditionalSubProduct NGAS);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("RNNG"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getRNNG());
			processRosetta(path.newSubPath("LGHT"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getLGHT());
			processRosetta(path.newSubPath("ELEC"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getELEC());
			processRosetta(path.newSubPath("DIST"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getDIST());
			processRosetta(path.newSubPath("COAL"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getCOAL());
			processRosetta(path.newSubPath("INRG"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getINRG());
			processRosetta(path.newSubPath("OILP"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getOILP());
			processRosetta(path.newSubPath("NGAS"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getNGAS());
		}
		

		AnnaDsbNRGY.AnnaDsbNRGYBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbNRGY  ***********************/
	class AnnaDsbNRGYImpl implements AnnaDsbNRGY {
		private final AnnaDsbEmpty rNNG;
		private final AnnaDsbEmpty lGHT;
		private final AnnaDsbAdditionalSubProduct eLEC;
		private final AnnaDsbEmpty dIST;
		private final AnnaDsbEmpty cOAL;
		private final AnnaDsbEmpty iNRG;
		private final AnnaDsbAdditionalSubProduct oILP;
		private final AnnaDsbAdditionalSubProduct nGAS;
		
		protected AnnaDsbNRGYImpl(AnnaDsbNRGY.AnnaDsbNRGYBuilder builder) {
			this.rNNG = ofNullable(builder.getRNNG()).map(f->f.build()).orElse(null);
			this.lGHT = ofNullable(builder.getLGHT()).map(f->f.build()).orElse(null);
			this.eLEC = ofNullable(builder.getELEC()).map(f->f.build()).orElse(null);
			this.dIST = ofNullable(builder.getDIST()).map(f->f.build()).orElse(null);
			this.cOAL = ofNullable(builder.getCOAL()).map(f->f.build()).orElse(null);
			this.iNRG = ofNullable(builder.getINRG()).map(f->f.build()).orElse(null);
			this.oILP = ofNullable(builder.getOILP()).map(f->f.build()).orElse(null);
			this.nGAS = ofNullable(builder.getNGAS()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("RNNG")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("RNNG")
		public AnnaDsbEmpty getRNNG() {
			return rNNG;
		}
		
		@Override
		@RosettaAttribute("LGHT")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("LGHT")
		public AnnaDsbEmpty getLGHT() {
			return lGHT;
		}
		
		@Override
		@RosettaAttribute("ELEC")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ELEC")
		public AnnaDsbAdditionalSubProduct getELEC() {
			return eLEC;
		}
		
		@Override
		@RosettaAttribute("DIST")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DIST")
		public AnnaDsbEmpty getDIST() {
			return dIST;
		}
		
		@Override
		@RosettaAttribute("COAL")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("COAL")
		public AnnaDsbEmpty getCOAL() {
			return cOAL;
		}
		
		@Override
		@RosettaAttribute("INRG")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("INRG")
		public AnnaDsbEmpty getINRG() {
			return iNRG;
		}
		
		@Override
		@RosettaAttribute("OILP")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OILP")
		public AnnaDsbAdditionalSubProduct getOILP() {
			return oILP;
		}
		
		@Override
		@RosettaAttribute("NGAS")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NGAS")
		public AnnaDsbAdditionalSubProduct getNGAS() {
			return nGAS;
		}
		
		@Override
		public AnnaDsbNRGY build() {
			return this;
		}
		
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder toBuilder() {
			AnnaDsbNRGY.AnnaDsbNRGYBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbNRGY.AnnaDsbNRGYBuilder builder) {
			ofNullable(getRNNG()).ifPresent(builder::setRNNG);
			ofNullable(getLGHT()).ifPresent(builder::setLGHT);
			ofNullable(getELEC()).ifPresent(builder::setELEC);
			ofNullable(getDIST()).ifPresent(builder::setDIST);
			ofNullable(getCOAL()).ifPresent(builder::setCOAL);
			ofNullable(getINRG()).ifPresent(builder::setINRG);
			ofNullable(getOILP()).ifPresent(builder::setOILP);
			ofNullable(getNGAS()).ifPresent(builder::setNGAS);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbNRGY _that = getType().cast(o);
		
			if (!Objects.equals(rNNG, _that.getRNNG())) return false;
			if (!Objects.equals(lGHT, _that.getLGHT())) return false;
			if (!Objects.equals(eLEC, _that.getELEC())) return false;
			if (!Objects.equals(dIST, _that.getDIST())) return false;
			if (!Objects.equals(cOAL, _that.getCOAL())) return false;
			if (!Objects.equals(iNRG, _that.getINRG())) return false;
			if (!Objects.equals(oILP, _that.getOILP())) return false;
			if (!Objects.equals(nGAS, _that.getNGAS())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rNNG != null ? rNNG.hashCode() : 0);
			_result = 31 * _result + (lGHT != null ? lGHT.hashCode() : 0);
			_result = 31 * _result + (eLEC != null ? eLEC.hashCode() : 0);
			_result = 31 * _result + (dIST != null ? dIST.hashCode() : 0);
			_result = 31 * _result + (cOAL != null ? cOAL.hashCode() : 0);
			_result = 31 * _result + (iNRG != null ? iNRG.hashCode() : 0);
			_result = 31 * _result + (oILP != null ? oILP.hashCode() : 0);
			_result = 31 * _result + (nGAS != null ? nGAS.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbNRGY {" +
				"RNNG=" + this.rNNG + ", " +
				"LGHT=" + this.lGHT + ", " +
				"ELEC=" + this.eLEC + ", " +
				"DIST=" + this.dIST + ", " +
				"COAL=" + this.cOAL + ", " +
				"INRG=" + this.iNRG + ", " +
				"OILP=" + this.oILP + ", " +
				"NGAS=" + this.nGAS +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbNRGY  ***********************/
	class AnnaDsbNRGYBuilderImpl implements AnnaDsbNRGY.AnnaDsbNRGYBuilder {
	
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder rNNG;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder lGHT;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder eLEC;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder dIST;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder cOAL;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder iNRG;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder oILP;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder nGAS;
		
		@Override
		@RosettaAttribute("RNNG")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("RNNG")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getRNNG() {
			return rNNG;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateRNNG() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (rNNG!=null) {
				result = rNNG;
			}
			else {
				result = rNNG = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("LGHT")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("LGHT")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getLGHT() {
			return lGHT;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateLGHT() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (lGHT!=null) {
				result = lGHT;
			}
			else {
				result = lGHT = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ELEC")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ELEC")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getELEC() {
			return eLEC;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateELEC() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (eLEC!=null) {
				result = eLEC;
			}
			else {
				result = eLEC = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("DIST")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DIST")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getDIST() {
			return dIST;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateDIST() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (dIST!=null) {
				result = dIST;
			}
			else {
				result = dIST = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("COAL")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("COAL")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getCOAL() {
			return cOAL;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateCOAL() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (cOAL!=null) {
				result = cOAL;
			}
			else {
				result = cOAL = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("INRG")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("INRG")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getINRG() {
			return iNRG;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateINRG() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (iNRG!=null) {
				result = iNRG;
			}
			else {
				result = iNRG = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("OILP")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OILP")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOILP() {
			return oILP;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateOILP() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (oILP!=null) {
				result = oILP;
			}
			else {
				result = oILP = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("NGAS")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NGAS")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getNGAS() {
			return nGAS;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateNGAS() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (nGAS!=null) {
				result = nGAS;
			}
			else {
				result = nGAS = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("RNNG")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("RNNG")
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder setRNNG(AnnaDsbEmpty _rNNG) {
			this.rNNG = _rNNG == null ? null : _rNNG.toBuilder();
			return this;
		}
		
		@RosettaAttribute("LGHT")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("LGHT")
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder setLGHT(AnnaDsbEmpty _lGHT) {
			this.lGHT = _lGHT == null ? null : _lGHT.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ELEC")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ELEC")
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder setELEC(AnnaDsbAdditionalSubProduct _eLEC) {
			this.eLEC = _eLEC == null ? null : _eLEC.toBuilder();
			return this;
		}
		
		@RosettaAttribute("DIST")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DIST")
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder setDIST(AnnaDsbEmpty _dIST) {
			this.dIST = _dIST == null ? null : _dIST.toBuilder();
			return this;
		}
		
		@RosettaAttribute("COAL")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("COAL")
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder setCOAL(AnnaDsbEmpty _cOAL) {
			this.cOAL = _cOAL == null ? null : _cOAL.toBuilder();
			return this;
		}
		
		@RosettaAttribute("INRG")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("INRG")
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder setINRG(AnnaDsbEmpty _iNRG) {
			this.iNRG = _iNRG == null ? null : _iNRG.toBuilder();
			return this;
		}
		
		@RosettaAttribute("OILP")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OILP")
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder setOILP(AnnaDsbAdditionalSubProduct _oILP) {
			this.oILP = _oILP == null ? null : _oILP.toBuilder();
			return this;
		}
		
		@RosettaAttribute("NGAS")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NGAS")
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder setNGAS(AnnaDsbAdditionalSubProduct _nGAS) {
			this.nGAS = _nGAS == null ? null : _nGAS.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbNRGY build() {
			return new AnnaDsbNRGY.AnnaDsbNRGYImpl(this);
		}
		
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder prune() {
			if (rNNG!=null && !rNNG.prune().hasData()) rNNG = null;
			if (lGHT!=null && !lGHT.prune().hasData()) lGHT = null;
			if (eLEC!=null && !eLEC.prune().hasData()) eLEC = null;
			if (dIST!=null && !dIST.prune().hasData()) dIST = null;
			if (cOAL!=null && !cOAL.prune().hasData()) cOAL = null;
			if (iNRG!=null && !iNRG.prune().hasData()) iNRG = null;
			if (oILP!=null && !oILP.prune().hasData()) oILP = null;
			if (nGAS!=null && !nGAS.prune().hasData()) nGAS = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRNNG()!=null && getRNNG().hasData()) return true;
			if (getLGHT()!=null && getLGHT().hasData()) return true;
			if (getELEC()!=null && getELEC().hasData()) return true;
			if (getDIST()!=null && getDIST().hasData()) return true;
			if (getCOAL()!=null && getCOAL().hasData()) return true;
			if (getINRG()!=null && getINRG().hasData()) return true;
			if (getOILP()!=null && getOILP().hasData()) return true;
			if (getNGAS()!=null && getNGAS().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbNRGY.AnnaDsbNRGYBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbNRGY.AnnaDsbNRGYBuilder o = (AnnaDsbNRGY.AnnaDsbNRGYBuilder) other;
			
			merger.mergeRosetta(getRNNG(), o.getRNNG(), this::setRNNG);
			merger.mergeRosetta(getLGHT(), o.getLGHT(), this::setLGHT);
			merger.mergeRosetta(getELEC(), o.getELEC(), this::setELEC);
			merger.mergeRosetta(getDIST(), o.getDIST(), this::setDIST);
			merger.mergeRosetta(getCOAL(), o.getCOAL(), this::setCOAL);
			merger.mergeRosetta(getINRG(), o.getINRG(), this::setINRG);
			merger.mergeRosetta(getOILP(), o.getOILP(), this::setOILP);
			merger.mergeRosetta(getNGAS(), o.getNGAS(), this::setNGAS);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbNRGY _that = getType().cast(o);
		
			if (!Objects.equals(rNNG, _that.getRNNG())) return false;
			if (!Objects.equals(lGHT, _that.getLGHT())) return false;
			if (!Objects.equals(eLEC, _that.getELEC())) return false;
			if (!Objects.equals(dIST, _that.getDIST())) return false;
			if (!Objects.equals(cOAL, _that.getCOAL())) return false;
			if (!Objects.equals(iNRG, _that.getINRG())) return false;
			if (!Objects.equals(oILP, _that.getOILP())) return false;
			if (!Objects.equals(nGAS, _that.getNGAS())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rNNG != null ? rNNG.hashCode() : 0);
			_result = 31 * _result + (lGHT != null ? lGHT.hashCode() : 0);
			_result = 31 * _result + (eLEC != null ? eLEC.hashCode() : 0);
			_result = 31 * _result + (dIST != null ? dIST.hashCode() : 0);
			_result = 31 * _result + (cOAL != null ? cOAL.hashCode() : 0);
			_result = 31 * _result + (iNRG != null ? iNRG.hashCode() : 0);
			_result = 31 * _result + (oILP != null ? oILP.hashCode() : 0);
			_result = 31 * _result + (nGAS != null ? nGAS.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbNRGYBuilder {" +
				"RNNG=" + this.rNNG + ", " +
				"LGHT=" + this.lGHT + ", " +
				"ELEC=" + this.eLEC + ", " +
				"DIST=" + this.dIST + ", " +
				"COAL=" + this.cOAL + ", " +
				"INRG=" + this.iNRG + ", " +
				"OILP=" + this.oILP + ", " +
				"NGAS=" + this.nGAS +
			'}';
		}
	}
}
