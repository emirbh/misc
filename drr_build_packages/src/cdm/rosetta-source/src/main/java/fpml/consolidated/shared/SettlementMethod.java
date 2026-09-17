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
import fpml.consolidated.shared.meta.SettlementMethodMeta;
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
@RosettaDataType(value="SettlementMethod", builder=SettlementMethod.SettlementMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementMethod", model="fpml", builder=SettlementMethod.SettlementMethodBuilderImpl.class, version="2.1.1")
public interface SettlementMethod extends RosettaModelObject {

	SettlementMethodMeta metaData = new SettlementMethodMeta();

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
	String getSettlementMethodScheme();

	/*********************** Build Methods  ***********************/
	SettlementMethod build();
	
	SettlementMethod.SettlementMethodBuilder toBuilder();
	
	static SettlementMethod.SettlementMethodBuilder builder() {
		return new SettlementMethod.SettlementMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementMethod> getType() {
		return SettlementMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("settlementMethodScheme"), String.class, getSettlementMethodScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementMethodBuilder extends SettlementMethod, RosettaModelObjectBuilder {
		SettlementMethod.SettlementMethodBuilder setValue(String value);
		SettlementMethod.SettlementMethodBuilder setSettlementMethodScheme(String settlementMethodScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("settlementMethodScheme"), String.class, getSettlementMethodScheme(), this);
		}
		

		SettlementMethod.SettlementMethodBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementMethod  ***********************/
	class SettlementMethodImpl implements SettlementMethod {
		private final String value;
		private final String settlementMethodScheme;
		
		protected SettlementMethodImpl(SettlementMethod.SettlementMethodBuilder builder) {
			this.value = builder.getValue();
			this.settlementMethodScheme = builder.getSettlementMethodScheme();
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
		@RosettaAttribute("settlementMethodScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementMethodScheme")
		public String getSettlementMethodScheme() {
			return settlementMethodScheme;
		}
		
		@Override
		public SettlementMethod build() {
			return this;
		}
		
		@Override
		public SettlementMethod.SettlementMethodBuilder toBuilder() {
			SettlementMethod.SettlementMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementMethod.SettlementMethodBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSettlementMethodScheme()).ifPresent(builder::setSettlementMethodScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementMethodScheme, _that.getSettlementMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementMethodScheme != null ? settlementMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementMethod {" +
				"value=" + this.value + ", " +
				"settlementMethodScheme=" + this.settlementMethodScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementMethod  ***********************/
	class SettlementMethodBuilderImpl implements SettlementMethod.SettlementMethodBuilder {
	
		protected String value;
		protected String settlementMethodScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settlementMethodScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementMethodScheme")
		public String getSettlementMethodScheme() {
			return settlementMethodScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public SettlementMethod.SettlementMethodBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("settlementMethodScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementMethodScheme")
		@Override
		public SettlementMethod.SettlementMethodBuilder setSettlementMethodScheme(String _settlementMethodScheme) {
			this.settlementMethodScheme = _settlementMethodScheme == null ? null : _settlementMethodScheme;
			return this;
		}
		
		@Override
		public SettlementMethod build() {
			return new SettlementMethod.SettlementMethodImpl(this);
		}
		
		@Override
		public SettlementMethod.SettlementMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementMethod.SettlementMethodBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSettlementMethodScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementMethod.SettlementMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementMethod.SettlementMethodBuilder o = (SettlementMethod.SettlementMethodBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSettlementMethodScheme(), o.getSettlementMethodScheme(), this::setSettlementMethodScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementMethod _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementMethodScheme, _that.getSettlementMethodScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementMethodScheme != null ? settlementMethodScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementMethodBuilder {" +
				"value=" + this.value + ", " +
				"settlementMethodScheme=" + this.settlementMethodScheme +
			'}';
		}
	}
}
