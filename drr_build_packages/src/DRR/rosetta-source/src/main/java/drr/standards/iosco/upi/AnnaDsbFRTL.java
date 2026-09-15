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
import drr.standards.iosco.upi.meta.AnnaDsbFRTLMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbFRTL", builder=AnnaDsbFRTL.AnnaDsbFRTLBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbFRTL", model="drr", builder=AnnaDsbFRTL.AnnaDsbFRTLBuilderImpl.class, version="7.7.0")
public interface AnnaDsbFRTL extends RosettaModelObject {

	AnnaDsbFRTLMeta metaData = new AnnaDsbFRTLMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbEmpty getAMMO();
	AnnaDsbEmpty getSLPH();
	AnnaDsbEmpty getDAPH();
	AnnaDsbEmpty getPTSH();
	AnnaDsbEmpty getUREA();
	AnnaDsbEmpty getUAAN();

	/*********************** Build Methods  ***********************/
	AnnaDsbFRTL build();
	
	AnnaDsbFRTL.AnnaDsbFRTLBuilder toBuilder();
	
	static AnnaDsbFRTL.AnnaDsbFRTLBuilder builder() {
		return new AnnaDsbFRTL.AnnaDsbFRTLBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbFRTL> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbFRTL> getType() {
		return AnnaDsbFRTL.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("AMMO"), processor, AnnaDsbEmpty.class, getAMMO());
		processRosetta(path.newSubPath("SLPH"), processor, AnnaDsbEmpty.class, getSLPH());
		processRosetta(path.newSubPath("DAPH"), processor, AnnaDsbEmpty.class, getDAPH());
		processRosetta(path.newSubPath("PTSH"), processor, AnnaDsbEmpty.class, getPTSH());
		processRosetta(path.newSubPath("UREA"), processor, AnnaDsbEmpty.class, getUREA());
		processRosetta(path.newSubPath("UAAN"), processor, AnnaDsbEmpty.class, getUAAN());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbFRTLBuilder extends AnnaDsbFRTL, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateAMMO();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getAMMO();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateSLPH();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getSLPH();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateDAPH();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getDAPH();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreatePTSH();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getPTSH();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateUREA();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getUREA();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateUAAN();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getUAAN();
		AnnaDsbFRTL.AnnaDsbFRTLBuilder setAMMO(AnnaDsbEmpty AMMO);
		AnnaDsbFRTL.AnnaDsbFRTLBuilder setSLPH(AnnaDsbEmpty SLPH);
		AnnaDsbFRTL.AnnaDsbFRTLBuilder setDAPH(AnnaDsbEmpty DAPH);
		AnnaDsbFRTL.AnnaDsbFRTLBuilder setPTSH(AnnaDsbEmpty PTSH);
		AnnaDsbFRTL.AnnaDsbFRTLBuilder setUREA(AnnaDsbEmpty UREA);
		AnnaDsbFRTL.AnnaDsbFRTLBuilder setUAAN(AnnaDsbEmpty UAAN);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("AMMO"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getAMMO());
			processRosetta(path.newSubPath("SLPH"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getSLPH());
			processRosetta(path.newSubPath("DAPH"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getDAPH());
			processRosetta(path.newSubPath("PTSH"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getPTSH());
			processRosetta(path.newSubPath("UREA"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getUREA());
			processRosetta(path.newSubPath("UAAN"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getUAAN());
		}
		

		AnnaDsbFRTL.AnnaDsbFRTLBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbFRTL  ***********************/
	class AnnaDsbFRTLImpl implements AnnaDsbFRTL {
		private final AnnaDsbEmpty aMMO;
		private final AnnaDsbEmpty sLPH;
		private final AnnaDsbEmpty dAPH;
		private final AnnaDsbEmpty pTSH;
		private final AnnaDsbEmpty uREA;
		private final AnnaDsbEmpty uAAN;
		
		protected AnnaDsbFRTLImpl(AnnaDsbFRTL.AnnaDsbFRTLBuilder builder) {
			this.aMMO = ofNullable(builder.getAMMO()).map(f->f.build()).orElse(null);
			this.sLPH = ofNullable(builder.getSLPH()).map(f->f.build()).orElse(null);
			this.dAPH = ofNullable(builder.getDAPH()).map(f->f.build()).orElse(null);
			this.pTSH = ofNullable(builder.getPTSH()).map(f->f.build()).orElse(null);
			this.uREA = ofNullable(builder.getUREA()).map(f->f.build()).orElse(null);
			this.uAAN = ofNullable(builder.getUAAN()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("AMMO")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("AMMO")
		public AnnaDsbEmpty getAMMO() {
			return aMMO;
		}
		
		@Override
		@RosettaAttribute("SLPH")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SLPH")
		public AnnaDsbEmpty getSLPH() {
			return sLPH;
		}
		
		@Override
		@RosettaAttribute("DAPH")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DAPH")
		public AnnaDsbEmpty getDAPH() {
			return dAPH;
		}
		
		@Override
		@RosettaAttribute("PTSH")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PTSH")
		public AnnaDsbEmpty getPTSH() {
			return pTSH;
		}
		
		@Override
		@RosettaAttribute("UREA")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UREA")
		public AnnaDsbEmpty getUREA() {
			return uREA;
		}
		
		@Override
		@RosettaAttribute("UAAN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UAAN")
		public AnnaDsbEmpty getUAAN() {
			return uAAN;
		}
		
		@Override
		public AnnaDsbFRTL build() {
			return this;
		}
		
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder toBuilder() {
			AnnaDsbFRTL.AnnaDsbFRTLBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbFRTL.AnnaDsbFRTLBuilder builder) {
			ofNullable(getAMMO()).ifPresent(builder::setAMMO);
			ofNullable(getSLPH()).ifPresent(builder::setSLPH);
			ofNullable(getDAPH()).ifPresent(builder::setDAPH);
			ofNullable(getPTSH()).ifPresent(builder::setPTSH);
			ofNullable(getUREA()).ifPresent(builder::setUREA);
			ofNullable(getUAAN()).ifPresent(builder::setUAAN);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbFRTL _that = getType().cast(o);
		
			if (!Objects.equals(aMMO, _that.getAMMO())) return false;
			if (!Objects.equals(sLPH, _that.getSLPH())) return false;
			if (!Objects.equals(dAPH, _that.getDAPH())) return false;
			if (!Objects.equals(pTSH, _that.getPTSH())) return false;
			if (!Objects.equals(uREA, _that.getUREA())) return false;
			if (!Objects.equals(uAAN, _that.getUAAN())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (aMMO != null ? aMMO.hashCode() : 0);
			_result = 31 * _result + (sLPH != null ? sLPH.hashCode() : 0);
			_result = 31 * _result + (dAPH != null ? dAPH.hashCode() : 0);
			_result = 31 * _result + (pTSH != null ? pTSH.hashCode() : 0);
			_result = 31 * _result + (uREA != null ? uREA.hashCode() : 0);
			_result = 31 * _result + (uAAN != null ? uAAN.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbFRTL {" +
				"AMMO=" + this.aMMO + ", " +
				"SLPH=" + this.sLPH + ", " +
				"DAPH=" + this.dAPH + ", " +
				"PTSH=" + this.pTSH + ", " +
				"UREA=" + this.uREA + ", " +
				"UAAN=" + this.uAAN +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbFRTL  ***********************/
	class AnnaDsbFRTLBuilderImpl implements AnnaDsbFRTL.AnnaDsbFRTLBuilder {
	
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder aMMO;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder sLPH;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder dAPH;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder pTSH;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder uREA;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder uAAN;
		
		@Override
		@RosettaAttribute("AMMO")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("AMMO")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getAMMO() {
			return aMMO;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateAMMO() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (aMMO!=null) {
				result = aMMO;
			}
			else {
				result = aMMO = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("SLPH")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SLPH")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getSLPH() {
			return sLPH;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateSLPH() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (sLPH!=null) {
				result = sLPH;
			}
			else {
				result = sLPH = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("DAPH")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DAPH")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getDAPH() {
			return dAPH;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateDAPH() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (dAPH!=null) {
				result = dAPH;
			}
			else {
				result = dAPH = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("PTSH")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PTSH")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getPTSH() {
			return pTSH;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreatePTSH() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (pTSH!=null) {
				result = pTSH;
			}
			else {
				result = pTSH = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("UREA")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UREA")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getUREA() {
			return uREA;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateUREA() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (uREA!=null) {
				result = uREA;
			}
			else {
				result = uREA = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("UAAN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UAAN")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getUAAN() {
			return uAAN;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateUAAN() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (uAAN!=null) {
				result = uAAN;
			}
			else {
				result = uAAN = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("AMMO")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("AMMO")
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder setAMMO(AnnaDsbEmpty _aMMO) {
			this.aMMO = _aMMO == null ? null : _aMMO.toBuilder();
			return this;
		}
		
		@RosettaAttribute("SLPH")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SLPH")
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder setSLPH(AnnaDsbEmpty _sLPH) {
			this.sLPH = _sLPH == null ? null : _sLPH.toBuilder();
			return this;
		}
		
		@RosettaAttribute("DAPH")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DAPH")
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder setDAPH(AnnaDsbEmpty _dAPH) {
			this.dAPH = _dAPH == null ? null : _dAPH.toBuilder();
			return this;
		}
		
		@RosettaAttribute("PTSH")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("PTSH")
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder setPTSH(AnnaDsbEmpty _pTSH) {
			this.pTSH = _pTSH == null ? null : _pTSH.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UREA")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UREA")
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder setUREA(AnnaDsbEmpty _uREA) {
			this.uREA = _uREA == null ? null : _uREA.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UAAN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UAAN")
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder setUAAN(AnnaDsbEmpty _uAAN) {
			this.uAAN = _uAAN == null ? null : _uAAN.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbFRTL build() {
			return new AnnaDsbFRTL.AnnaDsbFRTLImpl(this);
		}
		
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder prune() {
			if (aMMO!=null && !aMMO.prune().hasData()) aMMO = null;
			if (sLPH!=null && !sLPH.prune().hasData()) sLPH = null;
			if (dAPH!=null && !dAPH.prune().hasData()) dAPH = null;
			if (pTSH!=null && !pTSH.prune().hasData()) pTSH = null;
			if (uREA!=null && !uREA.prune().hasData()) uREA = null;
			if (uAAN!=null && !uAAN.prune().hasData()) uAAN = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAMMO()!=null && getAMMO().hasData()) return true;
			if (getSLPH()!=null && getSLPH().hasData()) return true;
			if (getDAPH()!=null && getDAPH().hasData()) return true;
			if (getPTSH()!=null && getPTSH().hasData()) return true;
			if (getUREA()!=null && getUREA().hasData()) return true;
			if (getUAAN()!=null && getUAAN().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbFRTL.AnnaDsbFRTLBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbFRTL.AnnaDsbFRTLBuilder o = (AnnaDsbFRTL.AnnaDsbFRTLBuilder) other;
			
			merger.mergeRosetta(getAMMO(), o.getAMMO(), this::setAMMO);
			merger.mergeRosetta(getSLPH(), o.getSLPH(), this::setSLPH);
			merger.mergeRosetta(getDAPH(), o.getDAPH(), this::setDAPH);
			merger.mergeRosetta(getPTSH(), o.getPTSH(), this::setPTSH);
			merger.mergeRosetta(getUREA(), o.getUREA(), this::setUREA);
			merger.mergeRosetta(getUAAN(), o.getUAAN(), this::setUAAN);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbFRTL _that = getType().cast(o);
		
			if (!Objects.equals(aMMO, _that.getAMMO())) return false;
			if (!Objects.equals(sLPH, _that.getSLPH())) return false;
			if (!Objects.equals(dAPH, _that.getDAPH())) return false;
			if (!Objects.equals(pTSH, _that.getPTSH())) return false;
			if (!Objects.equals(uREA, _that.getUREA())) return false;
			if (!Objects.equals(uAAN, _that.getUAAN())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (aMMO != null ? aMMO.hashCode() : 0);
			_result = 31 * _result + (sLPH != null ? sLPH.hashCode() : 0);
			_result = 31 * _result + (dAPH != null ? dAPH.hashCode() : 0);
			_result = 31 * _result + (pTSH != null ? pTSH.hashCode() : 0);
			_result = 31 * _result + (uREA != null ? uREA.hashCode() : 0);
			_result = 31 * _result + (uAAN != null ? uAAN.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbFRTLBuilder {" +
				"AMMO=" + this.aMMO + ", " +
				"SLPH=" + this.sLPH + ", " +
				"DAPH=" + this.dAPH + ", " +
				"PTSH=" + this.pTSH + ", " +
				"UREA=" + this.uREA + ", " +
				"UAAN=" + this.uAAN +
			'}';
		}
	}
}
