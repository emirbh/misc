package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.AmountAndDirection106__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Posting of an item to a cash account, in the context of a cash transaction, that results in an increase or decrease to the balance of the account.
 * @version ${project.version}
 */
@RosettaDataType(value="AmountAndDirection106__3", builder=AmountAndDirection106__3.AmountAndDirection106__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AmountAndDirection106__3", model="iso20022", builder=AmountAndDirection106__3.AmountAndDirection106__3BuilderImpl.class, version="${project.version}")
public interface AmountAndDirection106__3 extends RosettaModelObject {

	AmountAndDirection106__3Meta metaData = new AmountAndDirection106__3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Amount of money in the cash entry.
	 */
	ActiveOrHistoricCurrencyAnd5DecimalAmount getAmt();
	/**
	 * Indicates that the amount value is positive or negative.
	 */
	Boolean getSgn();

	/*********************** Build Methods  ***********************/
	AmountAndDirection106__3 build();
	
	AmountAndDirection106__3.AmountAndDirection106__3Builder toBuilder();
	
	static AmountAndDirection106__3.AmountAndDirection106__3Builder builder() {
		return new AmountAndDirection106__3.AmountAndDirection106__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmountAndDirection106__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AmountAndDirection106__3> getType() {
		return AmountAndDirection106__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.class, getAmt());
		processor.processBasic(path.newSubPath("sgn"), Boolean.class, getSgn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmountAndDirection106__3Builder extends AmountAndDirection106__3, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateAmt();
		@Override
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getAmt();
		AmountAndDirection106__3.AmountAndDirection106__3Builder setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount amt);
		AmountAndDirection106__3.AmountAndDirection106__3Builder setSgn(Boolean sgn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amt"), processor, ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder.class, getAmt());
			processor.processBasic(path.newSubPath("sgn"), Boolean.class, getSgn(), this);
		}
		

		AmountAndDirection106__3.AmountAndDirection106__3Builder prune();
	}

	/*********************** Immutable Implementation of AmountAndDirection106__3  ***********************/
	class AmountAndDirection106__3Impl implements AmountAndDirection106__3 {
		private final ActiveOrHistoricCurrencyAnd5DecimalAmount amt;
		private final Boolean sgn;
		
		protected AmountAndDirection106__3Impl(AmountAndDirection106__3.AmountAndDirection106__3Builder builder) {
			this.amt = ofNullable(builder.getAmt()).map(f->f.build()).orElse(null);
			this.sgn = builder.getSgn();
		}
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount getAmt() {
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
		public AmountAndDirection106__3 build() {
			return this;
		}
		
		@Override
		public AmountAndDirection106__3.AmountAndDirection106__3Builder toBuilder() {
			AmountAndDirection106__3.AmountAndDirection106__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmountAndDirection106__3.AmountAndDirection106__3Builder builder) {
			ofNullable(getAmt()).ifPresent(builder::setAmt);
			ofNullable(getSgn()).ifPresent(builder::setSgn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmountAndDirection106__3 _that = getType().cast(o);
		
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
			return "AmountAndDirection106__3 {" +
				"amt=" + this.amt + ", " +
				"sgn=" + this.sgn +
			'}';
		}
	}

	/*********************** Builder Implementation of AmountAndDirection106__3  ***********************/
	class AmountAndDirection106__3BuilderImpl implements AmountAndDirection106__3.AmountAndDirection106__3Builder {
	
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder amt;
		protected Boolean sgn;
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getAmt() {
			return amt;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder getOrCreateAmt() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder result;
			if (amt!=null) {
				result = amt;
			}
			else {
				result = amt = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
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
		public AmountAndDirection106__3.AmountAndDirection106__3Builder setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount _amt) {
			this.amt = _amt == null ? null : _amt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sgn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sgn")
		@Override
		public AmountAndDirection106__3.AmountAndDirection106__3Builder setSgn(Boolean _sgn) {
			this.sgn = _sgn == null ? null : _sgn;
			return this;
		}
		
		@Override
		public AmountAndDirection106__3 build() {
			return new AmountAndDirection106__3.AmountAndDirection106__3Impl(this);
		}
		
		@Override
		public AmountAndDirection106__3.AmountAndDirection106__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountAndDirection106__3.AmountAndDirection106__3Builder prune() {
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
		public AmountAndDirection106__3.AmountAndDirection106__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AmountAndDirection106__3.AmountAndDirection106__3Builder o = (AmountAndDirection106__3.AmountAndDirection106__3Builder) other;
			
			merger.mergeRosetta(getAmt(), o.getAmt(), this::setAmt);
			
			merger.mergeBasic(getSgn(), o.getSgn(), this::setSgn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmountAndDirection106__3 _that = getType().cast(o);
		
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
			return "AmountAndDirection106__3Builder {" +
				"amt=" + this.amt + ", " +
				"sgn=" + this.sgn +
			'}';
		}
	}
}
