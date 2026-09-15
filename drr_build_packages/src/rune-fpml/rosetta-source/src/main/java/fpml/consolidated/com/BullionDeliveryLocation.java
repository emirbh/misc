package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.BullionDeliveryLocationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A scheme defining where bullion is to be delivered for a Bullion Transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A scheme defining where bullion is to be delivered for a Bullion Transaction.
 *
 */
@RosettaDataType(value="BullionDeliveryLocation", builder=BullionDeliveryLocation.BullionDeliveryLocationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BullionDeliveryLocation", model="fpml", builder=BullionDeliveryLocation.BullionDeliveryLocationBuilderImpl.class, version="2.1.1")
public interface BullionDeliveryLocation extends RosettaModelObject {

	BullionDeliveryLocationMeta metaData = new BullionDeliveryLocationMeta();

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
	String getBullionDeliveryLocationScheme();

	/*********************** Build Methods  ***********************/
	BullionDeliveryLocation build();
	
	BullionDeliveryLocation.BullionDeliveryLocationBuilder toBuilder();
	
	static BullionDeliveryLocation.BullionDeliveryLocationBuilder builder() {
		return new BullionDeliveryLocation.BullionDeliveryLocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BullionDeliveryLocation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BullionDeliveryLocation> getType() {
		return BullionDeliveryLocation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("bullionDeliveryLocationScheme"), String.class, getBullionDeliveryLocationScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BullionDeliveryLocationBuilder extends BullionDeliveryLocation, RosettaModelObjectBuilder {
		BullionDeliveryLocation.BullionDeliveryLocationBuilder setValue(String value);
		BullionDeliveryLocation.BullionDeliveryLocationBuilder setBullionDeliveryLocationScheme(String bullionDeliveryLocationScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("bullionDeliveryLocationScheme"), String.class, getBullionDeliveryLocationScheme(), this);
		}
		

		BullionDeliveryLocation.BullionDeliveryLocationBuilder prune();
	}

	/*********************** Immutable Implementation of BullionDeliveryLocation  ***********************/
	class BullionDeliveryLocationImpl implements BullionDeliveryLocation {
		private final String value;
		private final String bullionDeliveryLocationScheme;
		
		protected BullionDeliveryLocationImpl(BullionDeliveryLocation.BullionDeliveryLocationBuilder builder) {
			this.value = builder.getValue();
			this.bullionDeliveryLocationScheme = builder.getBullionDeliveryLocationScheme();
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
		@RosettaAttribute("bullionDeliveryLocationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bullionDeliveryLocationScheme")
		public String getBullionDeliveryLocationScheme() {
			return bullionDeliveryLocationScheme;
		}
		
		@Override
		public BullionDeliveryLocation build() {
			return this;
		}
		
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder toBuilder() {
			BullionDeliveryLocation.BullionDeliveryLocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BullionDeliveryLocation.BullionDeliveryLocationBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getBullionDeliveryLocationScheme()).ifPresent(builder::setBullionDeliveryLocationScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BullionDeliveryLocation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(bullionDeliveryLocationScheme, _that.getBullionDeliveryLocationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (bullionDeliveryLocationScheme != null ? bullionDeliveryLocationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BullionDeliveryLocation {" +
				"value=" + this.value + ", " +
				"bullionDeliveryLocationScheme=" + this.bullionDeliveryLocationScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of BullionDeliveryLocation  ***********************/
	class BullionDeliveryLocationBuilderImpl implements BullionDeliveryLocation.BullionDeliveryLocationBuilder {
	
		protected String value;
		protected String bullionDeliveryLocationScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("bullionDeliveryLocationScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bullionDeliveryLocationScheme")
		public String getBullionDeliveryLocationScheme() {
			return bullionDeliveryLocationScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("bullionDeliveryLocationScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bullionDeliveryLocationScheme")
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder setBullionDeliveryLocationScheme(String _bullionDeliveryLocationScheme) {
			this.bullionDeliveryLocationScheme = _bullionDeliveryLocationScheme == null ? null : _bullionDeliveryLocationScheme;
			return this;
		}
		
		@Override
		public BullionDeliveryLocation build() {
			return new BullionDeliveryLocation.BullionDeliveryLocationImpl(this);
		}
		
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getBullionDeliveryLocationScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BullionDeliveryLocation.BullionDeliveryLocationBuilder o = (BullionDeliveryLocation.BullionDeliveryLocationBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getBullionDeliveryLocationScheme(), o.getBullionDeliveryLocationScheme(), this::setBullionDeliveryLocationScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BullionDeliveryLocation _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(bullionDeliveryLocationScheme, _that.getBullionDeliveryLocationScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (bullionDeliveryLocationScheme != null ? bullionDeliveryLocationScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BullionDeliveryLocationBuilder {" +
				"value=" + this.value + ", " +
				"bullionDeliveryLocationScheme=" + this.bullionDeliveryLocationScheme +
			'}';
		}
	}
}
