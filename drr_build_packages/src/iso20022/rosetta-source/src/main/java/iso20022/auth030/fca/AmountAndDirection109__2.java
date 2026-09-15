package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.AmountAndDirection109__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Posting of an item to a cash account, in the context of a cash transaction, that results in an increase or decrease to the balance of the account.
 * @version ${project.version}
 */
@RosettaDataType(value="AmountAndDirection109__2", builder=AmountAndDirection109__2.AmountAndDirection109__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AmountAndDirection109__2", model="iso20022", builder=AmountAndDirection109__2.AmountAndDirection109__2BuilderImpl.class, version="${project.version}")
public interface AmountAndDirection109__2 extends RosettaModelObject {

	AmountAndDirection109__2Meta metaData = new AmountAndDirection109__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Amount of money in the cash entry.
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount__1 getAmt();
	/**
	 * Indicates that the amount value is positive or negative.
	 */
	Boolean getSgn();

	/*********************** Build Methods  ***********************/
	AmountAndDirection109__2 build();
	
	AmountAndDirection109__2.AmountAndDirection109__2Builder toBuilder();
	
	static AmountAndDirection109__2.AmountAndDirection109__2Builder builder() {
		return new AmountAndDirection109__2.AmountAndDirection109__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmountAndDirection109__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AmountAndDirection109__2> getType() {
		return AmountAndDirection109__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount__1.class, getAmt());
		processor.processBasic(path.newSubPath("sgn"), Boolean.class, getSgn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmountAndDirection109__2Builder extends AmountAndDirection109__2, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder getOrCreateAmt();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder getAmt();
		AmountAndDirection109__2.AmountAndDirection109__2Builder setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1 amt);
		AmountAndDirection109__2.AmountAndDirection109__2Builder setSgn(Boolean sgn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder.class, getAmt());
			processor.processBasic(path.newSubPath("sgn"), Boolean.class, getSgn(), this);
		}
		

		AmountAndDirection109__2.AmountAndDirection109__2Builder prune();
	}

	/*********************** Immutable Implementation of AmountAndDirection109__2  ***********************/
	class AmountAndDirection109__2Impl implements AmountAndDirection109__2 {
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount__1 amt;
		private final Boolean sgn;
		
		protected AmountAndDirection109__2Impl(AmountAndDirection109__2.AmountAndDirection109__2Builder builder) {
			this.amt = ofNullable(builder.getAmt()).map(f->f.build()).orElse(null);
			this.sgn = builder.getSgn();
		}
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1 getAmt() {
			return amt;
		}
		
		@Override
		@RosettaAttribute("sgn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sgn")
		public Boolean getSgn() {
			return sgn;
		}
		
		@Override
		public AmountAndDirection109__2 build() {
			return this;
		}
		
		@Override
		public AmountAndDirection109__2.AmountAndDirection109__2Builder toBuilder() {
			AmountAndDirection109__2.AmountAndDirection109__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmountAndDirection109__2.AmountAndDirection109__2Builder builder) {
			ofNullable(getAmt()).ifPresent(builder::setAmt);
			ofNullable(getSgn()).ifPresent(builder::setSgn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmountAndDirection109__2 _that = getType().cast(o);
		
			if (!Objects.equals(amt, _that.getAmt())) return false;
			if (!Objects.equals(sgn, _that.getSgn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amt != null ? amt.hashCode() : 0);
			_result = 31 * _result + (sgn != null ? sgn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmountAndDirection109__2 {" +
				"amt=" + this.amt + ", " +
				"sgn=" + this.sgn +
			'}';
		}
	}

	/*********************** Builder Implementation of AmountAndDirection109__2  ***********************/
	class AmountAndDirection109__2BuilderImpl implements AmountAndDirection109__2.AmountAndDirection109__2Builder {
	
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder amt;
		protected Boolean sgn;
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder getAmt() {
			return amt;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder getOrCreateAmt() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder result;
			if (amt!=null) {
				result = amt;
			}
			else {
				result = amt = ActiveOrHistoricCurrencyAnd5DecimalAmount__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sgn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sgn")
		public Boolean getSgn() {
			return sgn;
		}
		
		@RosettaAttribute("amt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amt")
		@Override
		public AmountAndDirection109__2.AmountAndDirection109__2Builder setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1 _amt) {
			this.amt = _amt == null ? null : _amt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sgn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sgn")
		@Override
		public AmountAndDirection109__2.AmountAndDirection109__2Builder setSgn(Boolean _sgn) {
			this.sgn = _sgn == null ? null : _sgn;
			return this;
		}
		
		@Override
		public AmountAndDirection109__2 build() {
			return new AmountAndDirection109__2.AmountAndDirection109__2Impl(this);
		}
		
		@Override
		public AmountAndDirection109__2.AmountAndDirection109__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountAndDirection109__2.AmountAndDirection109__2Builder prune() {
			if (amt!=null && !amt.prune().hasData()) amt = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmt()!=null && getAmt().hasData()) return true;
			if (getSgn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountAndDirection109__2.AmountAndDirection109__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AmountAndDirection109__2.AmountAndDirection109__2Builder o = (AmountAndDirection109__2.AmountAndDirection109__2Builder) other;
			
			merger.mergeRosetta(getAmt(), o.getAmt(), this::setAmt);
			
			merger.mergeBasic(getSgn(), o.getSgn(), this::setSgn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmountAndDirection109__2 _that = getType().cast(o);
		
			if (!Objects.equals(amt, _that.getAmt())) return false;
			if (!Objects.equals(sgn, _that.getSgn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amt != null ? amt.hashCode() : 0);
			_result = 31 * _result + (sgn != null ? sgn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AmountAndDirection109__2Builder {" +
				"amt=" + this.amt + ", " +
				"sgn=" + this.sgn +
			'}';
		}
	}
}
