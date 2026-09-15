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
import fpml.consolidated.shared.meta.SettlementPriceSourceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The source from which the settlement price is to be obtained, e.g. a Reuters page, Prezzo di Riferimento, etc.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The source from which the settlement price is to be obtained, e.g. a Reuters page, Prezzo di Riferimento, etc.
 *
 */
@RosettaDataType(value="SettlementPriceSource", builder=SettlementPriceSource.SettlementPriceSourceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SettlementPriceSource", model="fpml", builder=SettlementPriceSource.SettlementPriceSourceBuilderImpl.class, version="2.1.1")
public interface SettlementPriceSource extends RosettaModelObject {

	SettlementPriceSourceMeta metaData = new SettlementPriceSourceMeta();

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
	String getSettlementPriceSourceScheme();

	/*********************** Build Methods  ***********************/
	SettlementPriceSource build();
	
	SettlementPriceSource.SettlementPriceSourceBuilder toBuilder();
	
	static SettlementPriceSource.SettlementPriceSourceBuilder builder() {
		return new SettlementPriceSource.SettlementPriceSourceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementPriceSource> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SettlementPriceSource> getType() {
		return SettlementPriceSource.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("settlementPriceSourceScheme"), String.class, getSettlementPriceSourceScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementPriceSourceBuilder extends SettlementPriceSource, RosettaModelObjectBuilder {
		SettlementPriceSource.SettlementPriceSourceBuilder setValue(String value);
		SettlementPriceSource.SettlementPriceSourceBuilder setSettlementPriceSourceScheme(String settlementPriceSourceScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("settlementPriceSourceScheme"), String.class, getSettlementPriceSourceScheme(), this);
		}
		

		SettlementPriceSource.SettlementPriceSourceBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementPriceSource  ***********************/
	class SettlementPriceSourceImpl implements SettlementPriceSource {
		private final String value;
		private final String settlementPriceSourceScheme;
		
		protected SettlementPriceSourceImpl(SettlementPriceSource.SettlementPriceSourceBuilder builder) {
			this.value = builder.getValue();
			this.settlementPriceSourceScheme = builder.getSettlementPriceSourceScheme();
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
		@RosettaAttribute("settlementPriceSourceScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPriceSourceScheme")
		public String getSettlementPriceSourceScheme() {
			return settlementPriceSourceScheme;
		}
		
		@Override
		public SettlementPriceSource build() {
			return this;
		}
		
		@Override
		public SettlementPriceSource.SettlementPriceSourceBuilder toBuilder() {
			SettlementPriceSource.SettlementPriceSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementPriceSource.SettlementPriceSourceBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getSettlementPriceSourceScheme()).ifPresent(builder::setSettlementPriceSourceScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPriceSource _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementPriceSourceScheme, _that.getSettlementPriceSourceScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementPriceSourceScheme != null ? settlementPriceSourceScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPriceSource {" +
				"value=" + this.value + ", " +
				"settlementPriceSourceScheme=" + this.settlementPriceSourceScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementPriceSource  ***********************/
	class SettlementPriceSourceBuilderImpl implements SettlementPriceSource.SettlementPriceSourceBuilder {
	
		protected String value;
		protected String settlementPriceSourceScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("settlementPriceSourceScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPriceSourceScheme")
		public String getSettlementPriceSourceScheme() {
			return settlementPriceSourceScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public SettlementPriceSource.SettlementPriceSourceBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("settlementPriceSourceScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementPriceSourceScheme")
		@Override
		public SettlementPriceSource.SettlementPriceSourceBuilder setSettlementPriceSourceScheme(String _settlementPriceSourceScheme) {
			this.settlementPriceSourceScheme = _settlementPriceSourceScheme == null ? null : _settlementPriceSourceScheme;
			return this;
		}
		
		@Override
		public SettlementPriceSource build() {
			return new SettlementPriceSource.SettlementPriceSourceImpl(this);
		}
		
		@Override
		public SettlementPriceSource.SettlementPriceSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPriceSource.SettlementPriceSourceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getSettlementPriceSourceScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementPriceSource.SettlementPriceSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementPriceSource.SettlementPriceSourceBuilder o = (SettlementPriceSource.SettlementPriceSourceBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getSettlementPriceSourceScheme(), o.getSettlementPriceSourceScheme(), this::setSettlementPriceSourceScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementPriceSource _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(settlementPriceSourceScheme, _that.getSettlementPriceSourceScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (settlementPriceSourceScheme != null ? settlementPriceSourceScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementPriceSourceBuilder {" +
				"value=" + this.value + ", " +
				"settlementPriceSourceScheme=" + this.settlementPriceSourceScheme +
			'}';
		}
	}
}
