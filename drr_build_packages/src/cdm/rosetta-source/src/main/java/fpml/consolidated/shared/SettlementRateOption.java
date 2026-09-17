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
import fpml.consolidated.shared.meta.SettlementRateOptionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the settlement rate options through a scheme reflecting the terms of the Annex A to the 1998 FX and Currency Option Definitions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the settlement rate options through a scheme reflecting the terms of the Annex A to the 1998 FX and Currency Option Definitions.
 *
 */
@RosettaDataType(value="SettlementRateOption", builder=SettlementRateOption.SettlementRateOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementRateOption", model="fpml", builder=SettlementRateOption.SettlementRateOptionBuilderImpl.class, version="2.1.1")
public interface SettlementRateOption extends RosettaModelObject {

	SettlementRateOptionMeta metaData = new SettlementRateOptionMeta();

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
	String getSettlementRateOptionScheme();

	/*********************** Build Methods  ***********************/
	SettlementRateOption build();
	
	SettlementRateOption.SettlementRateOptionBuilder toBuilder();
	
	static SettlementRateOption.SettlementRateOptionBuilder builder() {
		return new SettlementRateOption.SettlementRateOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementRateOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementRateOption> getType() {
		return SettlementRateOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("settlementRateOptionScheme"), String.class, getSettlementRateOptionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementRateOptionBuilder extends SettlementRateOption, RosettaModelObjectBuilder {
		SettlementRateOption.SettlementRateOptionBuilder setValue(String value);
		SettlementRateOption.SettlementRateOptionBuilder setSettlementRateOptionScheme(String settlementRateOptionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("settlementRateOptionScheme"), String.class, getSettlementRateOptionScheme(), this);
		}
		

		SettlementRateOption.SettlementRateOptionBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementRateOption  ***********************/
	class SettlementRateOptionImpl implements SettlementRateOption {
		private final String value;
		private final String settlementRateOptionScheme;
		
		protected SettlementRateOptionImpl(SettlementRateOption.SettlementRateOptionBuilder builder) {
			this.value = builder.getValue();
			this.settlementRateOptionScheme = builder.getSettlementRateOptionScheme();
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
		@RosettaAttribute("settlementRateOptionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateOptionScheme")
		public String getSettlementRateOptionScheme() {
			return settlementRateOptionScheme;
		}
		
		@Override
		public SettlementRateOption build() {
			return this;
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder toBuilder() {
			SettlementRateOption.SettlementRateOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementRateOption.SettlementRateOptionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSettlementRateOptionScheme()).ifPresent(builder::setSettlementRateOptionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementRateOption _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementRateOptionScheme, _that.getSettlementRateOptionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementRateOptionScheme != null ? settlementRateOptionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementRateOption {" +
				"value=" + this.value + ", " +
				"settlementRateOptionScheme=" + this.settlementRateOptionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementRateOption  ***********************/
	class SettlementRateOptionBuilderImpl implements SettlementRateOption.SettlementRateOptionBuilder {
	
		protected String value;
		protected String settlementRateOptionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settlementRateOptionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementRateOptionScheme")
		public String getSettlementRateOptionScheme() {
			return settlementRateOptionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("settlementRateOptionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementRateOptionScheme")
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder setSettlementRateOptionScheme(String _settlementRateOptionScheme) {
			this.settlementRateOptionScheme = _settlementRateOptionScheme == null ? null : _settlementRateOptionScheme;
			return this;
		}
		
		@Override
		public SettlementRateOption build() {
			return new SettlementRateOption.SettlementRateOptionImpl(this);
		}
		
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSettlementRateOptionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementRateOption.SettlementRateOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementRateOption.SettlementRateOptionBuilder o = (SettlementRateOption.SettlementRateOptionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSettlementRateOptionScheme(), o.getSettlementRateOptionScheme(), this::setSettlementRateOptionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementRateOption _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementRateOptionScheme, _that.getSettlementRateOptionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementRateOptionScheme != null ? settlementRateOptionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementRateOptionBuilder {" +
				"value=" + this.value + ", " +
				"settlementRateOptionScheme=" + this.settlementRateOptionScheme +
			'}';
		}
	}
}
