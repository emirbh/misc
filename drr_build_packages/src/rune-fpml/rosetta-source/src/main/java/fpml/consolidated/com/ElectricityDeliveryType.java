package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.ElectricityDeliveryTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="ElectricityDeliveryType", builder=ElectricityDeliveryType.ElectricityDeliveryTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityDeliveryType", model="fpml", builder=ElectricityDeliveryType.ElectricityDeliveryTypeBuilderImpl.class, version="2.1.1")
public interface ElectricityDeliveryType extends RosettaModelObject {

	ElectricityDeliveryTypeMeta metaData = new ElectricityDeliveryTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates under what condtitions the Parties' delivery obligations apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates under what condtitions the Parties' delivery obligations apply.
	 *
	 */
	ElectricityDeliveryFirm getFirm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and set to true, indicates that delivery or receipt of the electricity may be interrupted for any reason or for no reason, without liability on the part of either Party. This element should never have a value of false.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and set to true, indicates that delivery or receipt of the electricity may be interrupted for any reason or for no reason, without liability on the part of either Party. This element should never have a value of false.
	 *
	 */
	Boolean getNonFirm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that the electricity is intended to be supplied from the owned or controlled generation or pre-existing purchased power assets of the system specified.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that the electricity is intended to be supplied from the owned or controlled generation or pre-existing purchased power assets of the system specified.
	 *
	 */
	ElectricityDeliverySystemFirm getSystemFirm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates that the electricity is intended to be supplied from a generation asset which can optionally be specified.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates that the electricity is intended to be supplied from a generation asset which can optionally be specified.
	 *
	 */
	ElectricityDeliveryUnitFirm getUnitFirm();

	/*********************** Build Methods  ***********************/
	ElectricityDeliveryType build();
	
	ElectricityDeliveryType.ElectricityDeliveryTypeBuilder toBuilder();
	
	static ElectricityDeliveryType.ElectricityDeliveryTypeBuilder builder() {
		return new ElectricityDeliveryType.ElectricityDeliveryTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDeliveryType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityDeliveryType> getType() {
		return ElectricityDeliveryType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("firm"), processor, ElectricityDeliveryFirm.class, getFirm());
		processor.processBasic(path.newSubPath("nonFirm"), Boolean.class, getNonFirm(), this);
		processRosetta(path.newSubPath("systemFirm"), processor, ElectricityDeliverySystemFirm.class, getSystemFirm());
		processRosetta(path.newSubPath("unitFirm"), processor, ElectricityDeliveryUnitFirm.class, getUnitFirm());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliveryTypeBuilder extends ElectricityDeliveryType, RosettaModelObjectBuilder {
		ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder getOrCreateFirm();
		@Override
		ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder getFirm();
		ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder getOrCreateSystemFirm();
		@Override
		ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder getSystemFirm();
		ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder getOrCreateUnitFirm();
		@Override
		ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder getUnitFirm();
		ElectricityDeliveryType.ElectricityDeliveryTypeBuilder setFirm(ElectricityDeliveryFirm firm);
		ElectricityDeliveryType.ElectricityDeliveryTypeBuilder setNonFirm(Boolean nonFirm);
		ElectricityDeliveryType.ElectricityDeliveryTypeBuilder setSystemFirm(ElectricityDeliverySystemFirm systemFirm);
		ElectricityDeliveryType.ElectricityDeliveryTypeBuilder setUnitFirm(ElectricityDeliveryUnitFirm unitFirm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("firm"), processor, ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder.class, getFirm());
			processor.processBasic(path.newSubPath("nonFirm"), Boolean.class, getNonFirm(), this);
			processRosetta(path.newSubPath("systemFirm"), processor, ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder.class, getSystemFirm());
			processRosetta(path.newSubPath("unitFirm"), processor, ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder.class, getUnitFirm());
		}
		

		ElectricityDeliveryType.ElectricityDeliveryTypeBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityDeliveryType  ***********************/
	class ElectricityDeliveryTypeImpl implements ElectricityDeliveryType {
		private final ElectricityDeliveryFirm firm;
		private final Boolean nonFirm;
		private final ElectricityDeliverySystemFirm systemFirm;
		private final ElectricityDeliveryUnitFirm unitFirm;
		
		protected ElectricityDeliveryTypeImpl(ElectricityDeliveryType.ElectricityDeliveryTypeBuilder builder) {
			this.firm = ofNullable(builder.getFirm()).map(f->f.build()).orElse(null);
			this.nonFirm = builder.getNonFirm();
			this.systemFirm = ofNullable(builder.getSystemFirm()).map(f->f.build()).orElse(null);
			this.unitFirm = ofNullable(builder.getUnitFirm()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("firm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firm")
		public ElectricityDeliveryFirm getFirm() {
			return firm;
		}
		
		@Override
		@RosettaAttribute("nonFirm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonFirm")
		public Boolean getNonFirm() {
			return nonFirm;
		}
		
		@Override
		@RosettaAttribute("systemFirm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("systemFirm")
		public ElectricityDeliverySystemFirm getSystemFirm() {
			return systemFirm;
		}
		
		@Override
		@RosettaAttribute("unitFirm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitFirm")
		public ElectricityDeliveryUnitFirm getUnitFirm() {
			return unitFirm;
		}
		
		@Override
		public ElectricityDeliveryType build() {
			return this;
		}
		
		@Override
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder toBuilder() {
			ElectricityDeliveryType.ElectricityDeliveryTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDeliveryType.ElectricityDeliveryTypeBuilder builder) {
			ofNullable(getFirm()).ifPresent(builder::setFirm);
			ofNullable(getNonFirm()).ifPresent(builder::setNonFirm);
			ofNullable(getSystemFirm()).ifPresent(builder::setSystemFirm);
			ofNullable(getUnitFirm()).ifPresent(builder::setUnitFirm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliveryType _that = getType().cast(o);
		
			if (!Objects.equals(firm, _that.getFirm())) return false;
			if (!Objects.equals(nonFirm, _that.getNonFirm())) return false;
			if (!Objects.equals(systemFirm, _that.getSystemFirm())) return false;
			if (!Objects.equals(unitFirm, _that.getUnitFirm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (firm != null ? firm.hashCode() : 0);
			_result = 31 * _result + (nonFirm != null ? nonFirm.hashCode() : 0);
			_result = 31 * _result + (systemFirm != null ? systemFirm.hashCode() : 0);
			_result = 31 * _result + (unitFirm != null ? unitFirm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliveryType {" +
				"firm=" + this.firm + ", " +
				"nonFirm=" + this.nonFirm + ", " +
				"systemFirm=" + this.systemFirm + ", " +
				"unitFirm=" + this.unitFirm +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDeliveryType  ***********************/
	class ElectricityDeliveryTypeBuilderImpl implements ElectricityDeliveryType.ElectricityDeliveryTypeBuilder {
	
		protected ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder firm;
		protected Boolean nonFirm;
		protected ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder systemFirm;
		protected ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder unitFirm;
		
		@Override
		@RosettaAttribute("firm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firm")
		public ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder getFirm() {
			return firm;
		}
		
		@Override
		public ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder getOrCreateFirm() {
			ElectricityDeliveryFirm.ElectricityDeliveryFirmBuilder result;
			if (firm!=null) {
				result = firm;
			}
			else {
				result = firm = ElectricityDeliveryFirm.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonFirm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nonFirm")
		public Boolean getNonFirm() {
			return nonFirm;
		}
		
		@Override
		@RosettaAttribute("systemFirm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("systemFirm")
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder getSystemFirm() {
			return systemFirm;
		}
		
		@Override
		public ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder getOrCreateSystemFirm() {
			ElectricityDeliverySystemFirm.ElectricityDeliverySystemFirmBuilder result;
			if (systemFirm!=null) {
				result = systemFirm;
			}
			else {
				result = systemFirm = ElectricityDeliverySystemFirm.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("unitFirm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitFirm")
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder getUnitFirm() {
			return unitFirm;
		}
		
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder getOrCreateUnitFirm() {
			ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder result;
			if (unitFirm!=null) {
				result = unitFirm;
			}
			else {
				result = unitFirm = ElectricityDeliveryUnitFirm.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("firm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firm")
		@Override
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder setFirm(ElectricityDeliveryFirm _firm) {
			this.firm = _firm == null ? null : _firm.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonFirm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nonFirm")
		@Override
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder setNonFirm(Boolean _nonFirm) {
			this.nonFirm = _nonFirm == null ? null : _nonFirm;
			return this;
		}
		
		@RosettaAttribute("systemFirm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("systemFirm")
		@Override
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder setSystemFirm(ElectricityDeliverySystemFirm _systemFirm) {
			this.systemFirm = _systemFirm == null ? null : _systemFirm.toBuilder();
			return this;
		}
		
		@RosettaAttribute("unitFirm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unitFirm")
		@Override
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder setUnitFirm(ElectricityDeliveryUnitFirm _unitFirm) {
			this.unitFirm = _unitFirm == null ? null : _unitFirm.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityDeliveryType build() {
			return new ElectricityDeliveryType.ElectricityDeliveryTypeImpl(this);
		}
		
		@Override
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder prune() {
			if (firm!=null && !firm.prune().hasData()) firm = null;
			if (systemFirm!=null && !systemFirm.prune().hasData()) systemFirm = null;
			if (unitFirm!=null && !unitFirm.prune().hasData()) unitFirm = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFirm()!=null && getFirm().hasData()) return true;
			if (getNonFirm()!=null) return true;
			if (getSystemFirm()!=null && getSystemFirm().hasData()) return true;
			if (getUnitFirm()!=null && getUnitFirm().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliveryType.ElectricityDeliveryTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDeliveryType.ElectricityDeliveryTypeBuilder o = (ElectricityDeliveryType.ElectricityDeliveryTypeBuilder) other;
			
			merger.mergeRosetta(getFirm(), o.getFirm(), this::setFirm);
			merger.mergeRosetta(getSystemFirm(), o.getSystemFirm(), this::setSystemFirm);
			merger.mergeRosetta(getUnitFirm(), o.getUnitFirm(), this::setUnitFirm);
			
			merger.mergeBasic(getNonFirm(), o.getNonFirm(), this::setNonFirm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliveryType _that = getType().cast(o);
		
			if (!Objects.equals(firm, _that.getFirm())) return false;
			if (!Objects.equals(nonFirm, _that.getNonFirm())) return false;
			if (!Objects.equals(systemFirm, _that.getSystemFirm())) return false;
			if (!Objects.equals(unitFirm, _that.getUnitFirm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (firm != null ? firm.hashCode() : 0);
			_result = 31 * _result + (nonFirm != null ? nonFirm.hashCode() : 0);
			_result = 31 * _result + (systemFirm != null ? systemFirm.hashCode() : 0);
			_result = 31 * _result + (unitFirm != null ? unitFirm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliveryTypeBuilder {" +
				"firm=" + this.firm + ", " +
				"nonFirm=" + this.nonFirm + ", " +
				"systemFirm=" + this.systemFirm + ", " +
				"unitFirm=" + this.unitFirm +
			'}';
		}
	}
}
