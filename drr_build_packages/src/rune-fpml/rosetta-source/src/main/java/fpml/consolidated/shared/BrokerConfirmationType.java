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
import fpml.consolidated.shared.meta.BrokerConfirmationTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Identifies the market sector in which the trade has been arranged.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Identifies the market sector in which the trade has been arranged.
 *
 */
@RosettaDataType(value="BrokerConfirmationType", builder=BrokerConfirmationType.BrokerConfirmationTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BrokerConfirmationType", model="fpml", builder=BrokerConfirmationType.BrokerConfirmationTypeBuilderImpl.class, version="2.1.1")
public interface BrokerConfirmationType extends RosettaModelObject {

	BrokerConfirmationTypeMeta metaData = new BrokerConfirmationTypeMeta();

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
	String getBrokerConfirmationTypeScheme();

	/*********************** Build Methods  ***********************/
	BrokerConfirmationType build();
	
	BrokerConfirmationType.BrokerConfirmationTypeBuilder toBuilder();
	
	static BrokerConfirmationType.BrokerConfirmationTypeBuilder builder() {
		return new BrokerConfirmationType.BrokerConfirmationTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BrokerConfirmationType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BrokerConfirmationType> getType() {
		return BrokerConfirmationType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("brokerConfirmationTypeScheme"), String.class, getBrokerConfirmationTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BrokerConfirmationTypeBuilder extends BrokerConfirmationType, RosettaModelObjectBuilder {
		BrokerConfirmationType.BrokerConfirmationTypeBuilder setValue(String value);
		BrokerConfirmationType.BrokerConfirmationTypeBuilder setBrokerConfirmationTypeScheme(String brokerConfirmationTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("brokerConfirmationTypeScheme"), String.class, getBrokerConfirmationTypeScheme(), this);
		}
		

		BrokerConfirmationType.BrokerConfirmationTypeBuilder prune();
	}

	/*********************** Immutable Implementation of BrokerConfirmationType  ***********************/
	class BrokerConfirmationTypeImpl implements BrokerConfirmationType {
		private final String value;
		private final String brokerConfirmationTypeScheme;
		
		protected BrokerConfirmationTypeImpl(BrokerConfirmationType.BrokerConfirmationTypeBuilder builder) {
			this.value = builder.getValue();
			this.brokerConfirmationTypeScheme = builder.getBrokerConfirmationTypeScheme();
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
		@RosettaAttribute("brokerConfirmationTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerConfirmationTypeScheme")
		public String getBrokerConfirmationTypeScheme() {
			return brokerConfirmationTypeScheme;
		}
		
		@Override
		public BrokerConfirmationType build() {
			return this;
		}
		
		@Override
		public BrokerConfirmationType.BrokerConfirmationTypeBuilder toBuilder() {
			BrokerConfirmationType.BrokerConfirmationTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BrokerConfirmationType.BrokerConfirmationTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getBrokerConfirmationTypeScheme()).ifPresent(builder::setBrokerConfirmationTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BrokerConfirmationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(brokerConfirmationTypeScheme, _that.getBrokerConfirmationTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (brokerConfirmationTypeScheme != null ? brokerConfirmationTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BrokerConfirmationType {" +
				"value=" + this.value + ", " +
				"brokerConfirmationTypeScheme=" + this.brokerConfirmationTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of BrokerConfirmationType  ***********************/
	class BrokerConfirmationTypeBuilderImpl implements BrokerConfirmationType.BrokerConfirmationTypeBuilder {
	
		protected String value;
		protected String brokerConfirmationTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("brokerConfirmationTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("brokerConfirmationTypeScheme")
		public String getBrokerConfirmationTypeScheme() {
			return brokerConfirmationTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public BrokerConfirmationType.BrokerConfirmationTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("brokerConfirmationTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("brokerConfirmationTypeScheme")
		@Override
		public BrokerConfirmationType.BrokerConfirmationTypeBuilder setBrokerConfirmationTypeScheme(String _brokerConfirmationTypeScheme) {
			this.brokerConfirmationTypeScheme = _brokerConfirmationTypeScheme == null ? null : _brokerConfirmationTypeScheme;
			return this;
		}
		
		@Override
		public BrokerConfirmationType build() {
			return new BrokerConfirmationType.BrokerConfirmationTypeImpl(this);
		}
		
		@Override
		public BrokerConfirmationType.BrokerConfirmationTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BrokerConfirmationType.BrokerConfirmationTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getBrokerConfirmationTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BrokerConfirmationType.BrokerConfirmationTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BrokerConfirmationType.BrokerConfirmationTypeBuilder o = (BrokerConfirmationType.BrokerConfirmationTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getBrokerConfirmationTypeScheme(), o.getBrokerConfirmationTypeScheme(), this::setBrokerConfirmationTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BrokerConfirmationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(brokerConfirmationTypeScheme, _that.getBrokerConfirmationTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (brokerConfirmationTypeScheme != null ? brokerConfirmationTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BrokerConfirmationTypeBuilder {" +
				"value=" + this.value + ", " +
				"brokerConfirmationTypeScheme=" + this.brokerConfirmationTypeScheme +
			'}';
		}
	}
}
