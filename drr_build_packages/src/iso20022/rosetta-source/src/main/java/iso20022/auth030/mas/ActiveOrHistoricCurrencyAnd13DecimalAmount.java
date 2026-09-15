package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.ActiveOrHistoricCurrencyAnd13DecimalAmountMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ActiveOrHistoricCurrencyAnd13DecimalAmount", builder=ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilderImpl.class, version="${project.version}")
@RuneDataType(value="ActiveOrHistoricCurrencyAnd13DecimalAmount", model="iso20022", builder=ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilderImpl.class, version="${project.version}")
public interface ActiveOrHistoricCurrencyAnd13DecimalAmount extends RosettaModelObject {

	ActiveOrHistoricCurrencyAnd13DecimalAmountMeta metaData = new ActiveOrHistoricCurrencyAnd13DecimalAmountMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getValue();
	String getCcy();

	/*********************** Build Methods  ***********************/
	ActiveOrHistoricCurrencyAnd13DecimalAmount build();
	
	ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder toBuilder();
	
	static ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder builder() {
		return new ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActiveOrHistoricCurrencyAnd13DecimalAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ActiveOrHistoricCurrencyAnd13DecimalAmount> getType() {
		return ActiveOrHistoricCurrencyAnd13DecimalAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder extends ActiveOrHistoricCurrencyAnd13DecimalAmount, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder setValue(BigDecimal value);
		ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder setCcy(String ccy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
		}
		

		ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder prune();
	}

	/*********************** Immutable Implementation of ActiveOrHistoricCurrencyAnd13DecimalAmount  ***********************/
	class ActiveOrHistoricCurrencyAnd13DecimalAmountImpl implements ActiveOrHistoricCurrencyAnd13DecimalAmount {
		private final BigDecimal value;
		private final String ccy;
		
		protected ActiveOrHistoricCurrencyAnd13DecimalAmountImpl(ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder builder) {
			this.value = builder.getValue();
			this.ccy = builder.getCcy();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ccy")
		public String getCcy() {
			return ccy;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd13DecimalAmount build() {
			return this;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder toBuilder() {
			ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCcy()).ifPresent(builder::setCcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActiveOrHistoricCurrencyAnd13DecimalAmount _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(ccy, _that.getCcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (ccy != null ? ccy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActiveOrHistoricCurrencyAnd13DecimalAmount {" +
				"value=" + this.value + ", " +
				"ccy=" + this.ccy +
			'}';
		}
	}

	/*********************** Builder Implementation of ActiveOrHistoricCurrencyAnd13DecimalAmount  ***********************/
	class ActiveOrHistoricCurrencyAnd13DecimalAmountBuilderImpl implements ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder {
	
		protected BigDecimal value;
		protected String ccy;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ccy")
		public String getCcy() {
			return ccy;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ccy")
		@Override
		public ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder setCcy(String _ccy) {
			this.ccy = _ccy == null ? null : _ccy;
			return this;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd13DecimalAmount build() {
			return new ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountImpl(this);
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCcy()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder o = (ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCcy(), o.getCcy(), this::setCcy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActiveOrHistoricCurrencyAnd13DecimalAmount _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(ccy, _that.getCcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (ccy != null ? ccy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder {" +
				"value=" + this.value + ", " +
				"ccy=" + this.ccy +
			'}';
		}
	}
}
