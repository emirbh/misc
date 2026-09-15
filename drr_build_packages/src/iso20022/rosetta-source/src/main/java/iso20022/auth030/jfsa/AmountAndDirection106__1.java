package iso20022.auth030.jfsa;

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
import iso20022.auth030.jfsa.meta.AmountAndDirection106__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="AmountAndDirection106__1", builder=AmountAndDirection106__1.AmountAndDirection106__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AmountAndDirection106__1", model="iso20022", builder=AmountAndDirection106__1.AmountAndDirection106__1BuilderImpl.class, version="${project.version}")
public interface AmountAndDirection106__1 extends RosettaModelObject {

	AmountAndDirection106__1Meta metaData = new AmountAndDirection106__1Meta();

	/*********************** Getter Methods  ***********************/
	ActiveOrHistoricCurrencyAnd13DecimalAmount getAmt();
	Boolean getSgn();

	/*********************** Build Methods  ***********************/
	AmountAndDirection106__1 build();
	
	AmountAndDirection106__1.AmountAndDirection106__1Builder toBuilder();
	
	static AmountAndDirection106__1.AmountAndDirection106__1Builder builder() {
		return new AmountAndDirection106__1.AmountAndDirection106__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AmountAndDirection106__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AmountAndDirection106__1> getType() {
		return AmountAndDirection106__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amt"), processor, ActiveOrHistoricCurrencyAnd13DecimalAmount.class, getAmt());
		processor.processBasic(path.newSubPath("sgn"), Boolean.class, getSgn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AmountAndDirection106__1Builder extends AmountAndDirection106__1, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder getOrCreateAmt();
		@Override
		ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder getAmt();
		AmountAndDirection106__1.AmountAndDirection106__1Builder setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount amt);
		AmountAndDirection106__1.AmountAndDirection106__1Builder setSgn(Boolean sgn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amt"), processor, ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder.class, getAmt());
			processor.processBasic(path.newSubPath("sgn"), Boolean.class, getSgn(), this);
		}
		

		AmountAndDirection106__1.AmountAndDirection106__1Builder prune();
	}

	/*********************** Immutable Implementation of AmountAndDirection106__1  ***********************/
	class AmountAndDirection106__1Impl implements AmountAndDirection106__1 {
		private final ActiveOrHistoricCurrencyAnd13DecimalAmount amt;
		private final Boolean sgn;
		
		protected AmountAndDirection106__1Impl(AmountAndDirection106__1.AmountAndDirection106__1Builder builder) {
			this.amt = ofNullable(builder.getAmt()).map(f->f.build()).orElse(null);
			this.sgn = builder.getSgn();
		}
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public ActiveOrHistoricCurrencyAnd13DecimalAmount getAmt() {
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
		public AmountAndDirection106__1 build() {
			return this;
		}
		
		@Override
		public AmountAndDirection106__1.AmountAndDirection106__1Builder toBuilder() {
			AmountAndDirection106__1.AmountAndDirection106__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AmountAndDirection106__1.AmountAndDirection106__1Builder builder) {
			ofNullable(getAmt()).ifPresent(builder::setAmt);
			ofNullable(getSgn()).ifPresent(builder::setSgn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmountAndDirection106__1 _that = getType().cast(o);
		
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
			return "AmountAndDirection106__1 {" +
				"amt=" + this.amt + ", " +
				"sgn=" + this.sgn +
			'}';
		}
	}

	/*********************** Builder Implementation of AmountAndDirection106__1  ***********************/
	class AmountAndDirection106__1BuilderImpl implements AmountAndDirection106__1.AmountAndDirection106__1Builder {
	
		protected ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder amt;
		protected Boolean sgn;
		
		@Override
		@RosettaAttribute("amt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amt")
		public ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder getAmt() {
			return amt;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder getOrCreateAmt() {
			ActiveOrHistoricCurrencyAnd13DecimalAmount.ActiveOrHistoricCurrencyAnd13DecimalAmountBuilder result;
			if (amt!=null) {
				result = amt;
			}
			else {
				result = amt = ActiveOrHistoricCurrencyAnd13DecimalAmount.builder();
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
		public AmountAndDirection106__1.AmountAndDirection106__1Builder setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount _amt) {
			this.amt = _amt == null ? null : _amt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sgn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sgn")
		@Override
		public AmountAndDirection106__1.AmountAndDirection106__1Builder setSgn(Boolean _sgn) {
			this.sgn = _sgn == null ? null : _sgn;
			return this;
		}
		
		@Override
		public AmountAndDirection106__1 build() {
			return new AmountAndDirection106__1.AmountAndDirection106__1Impl(this);
		}
		
		@Override
		public AmountAndDirection106__1.AmountAndDirection106__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AmountAndDirection106__1.AmountAndDirection106__1Builder prune() {
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
		public AmountAndDirection106__1.AmountAndDirection106__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AmountAndDirection106__1.AmountAndDirection106__1Builder o = (AmountAndDirection106__1.AmountAndDirection106__1Builder) other;
			
			merger.mergeRosetta(getAmt(), o.getAmt(), this::setAmt);
			
			merger.mergeBasic(getSgn(), o.getSgn(), this::setSgn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AmountAndDirection106__1 _that = getType().cast(o);
		
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
			return "AmountAndDirection106__1Builder {" +
				"amt=" + this.amt + ", " +
				"sgn=" + this.sgn +
			'}';
		}
	}
}
