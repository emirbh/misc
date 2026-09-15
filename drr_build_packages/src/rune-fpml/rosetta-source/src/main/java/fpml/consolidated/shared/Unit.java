package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.UnitMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type used to record information about a unit, subdivision, desk, or other similar business entity.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type used to record information about a unit, subdivision, desk, or other similar business entity.
 *
 */
@RosettaDataType(value="Unit", builder=Unit.UnitBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Unit", model="fpml", builder=Unit.UnitBuilderImpl.class, version="2.1.1")
public interface Unit extends RosettaModelObject {

	UnitMeta metaData = new UnitMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	String getValue();
	/**
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
	String getUnitScheme();

	/*********************** Build Methods  ***********************/
	Unit build();
	
	Unit.UnitBuilder toBuilder();
	
	static Unit.UnitBuilder builder() {
		return new Unit.UnitBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Unit> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Unit> getType() {
		return Unit.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("unitScheme"), String.class, getUnitScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnitBuilder extends Unit, RosettaModelObjectBuilder {
		Unit.UnitBuilder setValue(String value);
		Unit.UnitBuilder setUnitScheme(String unitScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("unitScheme"), String.class, getUnitScheme(), this);
		}
		

		Unit.UnitBuilder prune();
	}

	/*********************** Immutable Implementation of Unit  ***********************/
	class UnitImpl implements Unit {
		private final String value;
		private final String unitScheme;
		
		protected UnitImpl(Unit.UnitBuilder builder) {
			this.value = builder.getValue();
			this.unitScheme = builder.getUnitScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("unitScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitScheme")
		public String getUnitScheme() {
			return unitScheme;
		}
		
		@Override
		public Unit build() {
			return this;
		}
		
		@Override
		public Unit.UnitBuilder toBuilder() {
			Unit.UnitBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Unit.UnitBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getUnitScheme()).ifPresent(builder::setUnitScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Unit _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(unitScheme, _that.getUnitScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (unitScheme != null ? unitScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Unit {" +
				"value=" + this.value + ", " +
				"unitScheme=" + this.unitScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of Unit  ***********************/
	class UnitBuilderImpl implements Unit.UnitBuilder {
	
		protected String value;
		protected String unitScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("unitScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitScheme")
		public String getUnitScheme() {
			return unitScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public Unit.UnitBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("unitScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unitScheme")
		@Override
		public Unit.UnitBuilder setUnitScheme(String _unitScheme) {
			this.unitScheme = _unitScheme == null ? null : _unitScheme;
			return this;
		}
		
		@Override
		public Unit build() {
			return new Unit.UnitImpl(this);
		}
		
		@Override
		public Unit.UnitBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Unit.UnitBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getUnitScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Unit.UnitBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Unit.UnitBuilder o = (Unit.UnitBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getUnitScheme(), o.getUnitScheme(), this::setUnitScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Unit _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(unitScheme, _that.getUnitScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (unitScheme != null ? unitScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitBuilder {" +
				"value=" + this.value + ", " +
				"unitScheme=" + this.unitScheme +
			'}';
		}
	}
}
