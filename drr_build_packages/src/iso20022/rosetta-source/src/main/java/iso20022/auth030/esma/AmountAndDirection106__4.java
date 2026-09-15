package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.AmountAndDirection106__4Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Posting of an item to a cash account, in the context of a cash transaction, that results in an increase or decrease to the balance of the account.
 * @version ${project.version}
 */
@RosettaDataType(value="AmountAndDirection106__4", builder=AmountAndDirection106__4.AmountAndDirection106__4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AmountAndDirection106__4", model="iso20022", builder=AmountAndDirection106__4.AmountAndDirection106__4BuilderImpl.class, version="${project.version}")
public interface AmountAndDirection106__4 extends RosettaModelObject {

	AmountAndDirection106__4Meta metaData = new AmountAndDirection106__4Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Amount of money in the cash entry.
	 */
	ActiveOrHistoricCurrencyAnd13DecimalAmount__1 getAmt();

	/*********************** Build Methods  ***********************/
	AmountAndDirection106__4 build();
	
	AmountAndDirection106__4.AmountAndDirection106__4Builder toBuilder();
	
	static AmountAndDirection106__4.AmountAndDirection106__4Builder builder() {
		return new AmountAndDirection106__4.AmountAndDirection106__4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmountAndDirection106__4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AmountAndDirection106__4> getType() {
		return AmountAndDirection106__4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amt"), processor, ActiveOrHistoricCurrencyAnd13DecimalAmount__1.class, getAmt());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmountAndDirection106__4Builder extends AmountAndDirection106__4, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd13DecimalAmount__1.ActiveOrHistoricCurrencyAnd13DecimalAmount__1Builder getOrCreateAmt();
		@Override
		ActiveOrHistoricCurrencyAnd13DecimalAmount__1.ActiveOrHistoricCurrencyAnd13DecimalAmount__1Builder getAmt();
		AmountAndDirection106__4.AmountAndDirection106__4Builder setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount__1 amt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amt"), processor, ActiveOrHistoricCurrencyAnd13DecimalAmount__1.ActiveOrHistoricCurrencyAnd13DecimalAmount__1Builder.class, getAmt());
		}
		

		AmountAndDirection106__4.AmountAndDirection106__4Builder prune();
	}

	/*********************** Immutable Implementation of AmountAndDirection106__4  ***********************/
	class AmountAndDirection106__4Impl implements AmountAndDirection106__4 {
		private final ActiveOrHistoricCurrencyAnd13DecimalAmount__1 amt;
		
		protected AmountAndDirection106__4Impl(AmountAndDirection106__4.AmountAndDirection106__4Builder builder) {
			this.amt = ofNullable(builder.getAmt()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public ActiveOrHistoricCurrencyAnd13DecimalAmount__1 getAmt() {
			return amt;
		}
		
		@Override
		public AmountAndDirection106__4 build() {
			return this;
		}
		
		@Override
		public AmountAndDirection106__4.AmountAndDirection106__4Builder toBuilder() {
			AmountAndDirection106__4.AmountAndDirection106__4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmountAndDirection106__4.AmountAndDirection106__4Builder builder) {
			ofNullable(getAmt()).ifPresent(builder::setAmt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmountAndDirection106__4 _that = getType().cast(o);
		
			if (!Objects.equals(amt, _that.getAmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amt != null ? amt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmountAndDirection106__4 {" +
				"amt=" + this.amt +
			'}';
		}
	}

	/*********************** Builder Implementation of AmountAndDirection106__4  ***********************/
	class AmountAndDirection106__4BuilderImpl implements AmountAndDirection106__4.AmountAndDirection106__4Builder {
	
		protected ActiveOrHistoricCurrencyAnd13DecimalAmount__1.ActiveOrHistoricCurrencyAnd13DecimalAmount__1Builder amt;
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public ActiveOrHistoricCurrencyAnd13DecimalAmount__1.ActiveOrHistoricCurrencyAnd13DecimalAmount__1Builder getAmt() {
			return amt;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd13DecimalAmount__1.ActiveOrHistoricCurrencyAnd13DecimalAmount__1Builder getOrCreateAmt() {
			ActiveOrHistoricCurrencyAnd13DecimalAmount__1.ActiveOrHistoricCurrencyAnd13DecimalAmount__1Builder result;
			if (amt!=null) {
				result = amt;
			}
			else {
				result = amt = ActiveOrHistoricCurrencyAnd13DecimalAmount__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("amt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amt")
		@Override
		public AmountAndDirection106__4.AmountAndDirection106__4Builder setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount__1 _amt) {
			this.amt = _amt == null ? null : _amt.toBuilder();
			return this;
		}
		
		@Override
		public AmountAndDirection106__4 build() {
			return new AmountAndDirection106__4.AmountAndDirection106__4Impl(this);
		}
		
		@Override
		public AmountAndDirection106__4.AmountAndDirection106__4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountAndDirection106__4.AmountAndDirection106__4Builder prune() {
			if (amt!=null && !amt.prune().hasData()) amt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmt()!=null && getAmt().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountAndDirection106__4.AmountAndDirection106__4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AmountAndDirection106__4.AmountAndDirection106__4Builder o = (AmountAndDirection106__4.AmountAndDirection106__4Builder) other;
			
			merger.mergeRosetta(getAmt(), o.getAmt(), this::setAmt);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmountAndDirection106__4 _that = getType().cast(o);
		
			if (!Objects.equals(amt, _that.getAmt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amt != null ? amt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmountAndDirection106__4Builder {" +
				"amt=" + this.amt +
			'}';
		}
	}
}
