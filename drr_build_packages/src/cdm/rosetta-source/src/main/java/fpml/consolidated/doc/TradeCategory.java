package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.TradeCategoryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A scheme used to categorize positions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A scheme used to categorize positions.
 *
 */
@RosettaDataType(value="TradeCategory", builder=TradeCategory.TradeCategoryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TradeCategory", model="fpml", builder=TradeCategory.TradeCategoryBuilderImpl.class, version="2.1.1")
public interface TradeCategory extends RosettaModelObject {

	TradeCategoryMeta metaData = new TradeCategoryMeta();

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
	String getCategoryScheme();

	/*********************** Build Methods  ***********************/
	TradeCategory build();
	
	TradeCategory.TradeCategoryBuilder toBuilder();
	
	static TradeCategory.TradeCategoryBuilder builder() {
		return new TradeCategory.TradeCategoryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeCategory> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeCategory> getType() {
		return TradeCategory.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("categoryScheme"), String.class, getCategoryScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeCategoryBuilder extends TradeCategory, RosettaModelObjectBuilder {
		TradeCategory.TradeCategoryBuilder setValue(String value);
		TradeCategory.TradeCategoryBuilder setCategoryScheme(String categoryScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("categoryScheme"), String.class, getCategoryScheme(), this);
		}
		

		TradeCategory.TradeCategoryBuilder prune();
	}

	/*********************** Immutable Implementation of TradeCategory  ***********************/
	class TradeCategoryImpl implements TradeCategory {
		private final String value;
		private final String categoryScheme;
		
		protected TradeCategoryImpl(TradeCategory.TradeCategoryBuilder builder) {
			this.value = builder.getValue();
			this.categoryScheme = builder.getCategoryScheme();
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
		@RosettaAttribute("categoryScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("categoryScheme")
		public String getCategoryScheme() {
			return categoryScheme;
		}
		
		@Override
		public TradeCategory build() {
			return this;
		}
		
		@Override
		public TradeCategory.TradeCategoryBuilder toBuilder() {
			TradeCategory.TradeCategoryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeCategory.TradeCategoryBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCategoryScheme()).ifPresent(builder::setCategoryScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCategory _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(categoryScheme, _that.getCategoryScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (categoryScheme != null ? categoryScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCategory {" +
				"value=" + this.value + ", " +
				"categoryScheme=" + this.categoryScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeCategory  ***********************/
	class TradeCategoryBuilderImpl implements TradeCategory.TradeCategoryBuilder {
	
		protected String value;
		protected String categoryScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("categoryScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("categoryScheme")
		public String getCategoryScheme() {
			return categoryScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public TradeCategory.TradeCategoryBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("categoryScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("categoryScheme")
		@Override
		public TradeCategory.TradeCategoryBuilder setCategoryScheme(String _categoryScheme) {
			this.categoryScheme = _categoryScheme == null ? null : _categoryScheme;
			return this;
		}
		
		@Override
		public TradeCategory build() {
			return new TradeCategory.TradeCategoryImpl(this);
		}
		
		@Override
		public TradeCategory.TradeCategoryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCategory.TradeCategoryBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCategoryScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeCategory.TradeCategoryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeCategory.TradeCategoryBuilder o = (TradeCategory.TradeCategoryBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCategoryScheme(), o.getCategoryScheme(), this::setCategoryScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeCategory _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(categoryScheme, _that.getCategoryScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (categoryScheme != null ? categoryScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeCategoryBuilder {" +
				"value=" + this.value + ", " +
				"categoryScheme=" + this.categoryScheme +
			'}';
		}
	}
}
