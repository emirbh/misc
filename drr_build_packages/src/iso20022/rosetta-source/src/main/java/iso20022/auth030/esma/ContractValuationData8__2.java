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
import iso20022.auth030.esma.meta.ContractValuationData8__2Meta;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to contract valuation.
 * @version ${project.version}
 */
@RosettaDataType(value="ContractValuationData8__2", builder=ContractValuationData8__2.ContractValuationData8__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ContractValuationData8__2", model="iso20022", builder=ContractValuationData8__2.ContractValuationData8__2BuilderImpl.class, version="${project.version}")
public interface ContractValuationData8__2 extends RosettaModelObject {

	ContractValuationData8__2Meta metaData = new ContractValuationData8__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the current value of the outstanding contract.
	 */
	AmountAndDirection109__2 getCtrctVal();
	/**
	 * Indicates the date and time of the last valuation marked to market provided by the central counterparty (CCP) or calculated using the current or last available market price of the inputs.
	 */
	ZonedDateTime getTmStmp();
	/**
	 * Indicates the source and method used for the valuation of the transaction by the reporting counterparty.  Usage: If at least one valuation input is used that is classified as mark-to-model, the whole valuation is classified as mark-to-model. If only inputs are used that are classified as mark-to-market; the whole valuation is classified as mark-to-market.
	 */
	ValuationType1Code getTp();
	/**
	 * Specifies the ratio of the absolute change in price of a derivative transaction to the change in price of the underlier, at the time a new transaction is reported or when a change in the notional amount is reported.
	 */
	BigDecimal getDlta();

	/*********************** Build Methods  ***********************/
	ContractValuationData8__2 build();
	
	ContractValuationData8__2.ContractValuationData8__2Builder toBuilder();
	
	static ContractValuationData8__2.ContractValuationData8__2Builder builder() {
		return new ContractValuationData8__2.ContractValuationData8__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractValuationData8__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractValuationData8__2> getType() {
		return ContractValuationData8__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrctVal"), processor, AmountAndDirection109__2.class, getCtrctVal());
		processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
		processor.processBasic(path.newSubPath("tp"), ValuationType1Code.class, getTp(), this);
		processor.processBasic(path.newSubPath("dlta"), BigDecimal.class, getDlta(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractValuationData8__2Builder extends ContractValuationData8__2, RosettaModelObjectBuilder {
		AmountAndDirection109__2.AmountAndDirection109__2Builder getOrCreateCtrctVal();
		@Override
		AmountAndDirection109__2.AmountAndDirection109__2Builder getCtrctVal();
		ContractValuationData8__2.ContractValuationData8__2Builder setCtrctVal(AmountAndDirection109__2 ctrctVal);
		ContractValuationData8__2.ContractValuationData8__2Builder setTmStmp(ZonedDateTime tmStmp);
		ContractValuationData8__2.ContractValuationData8__2Builder setTp(ValuationType1Code tp);
		ContractValuationData8__2.ContractValuationData8__2Builder setDlta(BigDecimal dlta);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrctVal"), processor, AmountAndDirection109__2.AmountAndDirection109__2Builder.class, getCtrctVal());
			processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
			processor.processBasic(path.newSubPath("tp"), ValuationType1Code.class, getTp(), this);
			processor.processBasic(path.newSubPath("dlta"), BigDecimal.class, getDlta(), this);
		}
		

		ContractValuationData8__2.ContractValuationData8__2Builder prune();
	}

	/*********************** Immutable Implementation of ContractValuationData8__2  ***********************/
	class ContractValuationData8__2Impl implements ContractValuationData8__2 {
		private final AmountAndDirection109__2 ctrctVal;
		private final ZonedDateTime tmStmp;
		private final ValuationType1Code tp;
		private final BigDecimal dlta;
		
		protected ContractValuationData8__2Impl(ContractValuationData8__2.ContractValuationData8__2Builder builder) {
			this.ctrctVal = ofNullable(builder.getCtrctVal()).map(f->f.build()).orElse(null);
			this.tmStmp = builder.getTmStmp();
			this.tp = builder.getTp();
			this.dlta = builder.getDlta();
		}
		
		@Override
		@RosettaAttribute("ctrctVal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrctVal")
		public AmountAndDirection109__2 getCtrctVal() {
			return ctrctVal;
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tmStmp")
		public ZonedDateTime getTmStmp() {
			return tmStmp;
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public ValuationType1Code getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("dlta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dlta")
		public BigDecimal getDlta() {
			return dlta;
		}
		
		@Override
		public ContractValuationData8__2 build() {
			return this;
		}
		
		@Override
		public ContractValuationData8__2.ContractValuationData8__2Builder toBuilder() {
			ContractValuationData8__2.ContractValuationData8__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractValuationData8__2.ContractValuationData8__2Builder builder) {
			ofNullable(getCtrctVal()).ifPresent(builder::setCtrctVal);
			ofNullable(getTmStmp()).ifPresent(builder::setTmStmp);
			ofNullable(getTp()).ifPresent(builder::setTp);
			ofNullable(getDlta()).ifPresent(builder::setDlta);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractValuationData8__2 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctVal, _that.getCtrctVal())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(dlta, _that.getDlta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctVal != null ? ctrctVal.hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dlta != null ? dlta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractValuationData8__2 {" +
				"ctrctVal=" + this.ctrctVal + ", " +
				"tmStmp=" + this.tmStmp + ", " +
				"tp=" + this.tp + ", " +
				"dlta=" + this.dlta +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractValuationData8__2  ***********************/
	class ContractValuationData8__2BuilderImpl implements ContractValuationData8__2.ContractValuationData8__2Builder {
	
		protected AmountAndDirection109__2.AmountAndDirection109__2Builder ctrctVal;
		protected ZonedDateTime tmStmp;
		protected ValuationType1Code tp;
		protected BigDecimal dlta;
		
		@Override
		@RosettaAttribute("ctrctVal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrctVal")
		public AmountAndDirection109__2.AmountAndDirection109__2Builder getCtrctVal() {
			return ctrctVal;
		}
		
		@Override
		public AmountAndDirection109__2.AmountAndDirection109__2Builder getOrCreateCtrctVal() {
			AmountAndDirection109__2.AmountAndDirection109__2Builder result;
			if (ctrctVal!=null) {
				result = ctrctVal;
			}
			else {
				result = ctrctVal = AmountAndDirection109__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tmStmp")
		public ZonedDateTime getTmStmp() {
			return tmStmp;
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public ValuationType1Code getTp() {
			return tp;
		}
		
		@Override
		@RosettaAttribute("dlta")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dlta")
		public BigDecimal getDlta() {
			return dlta;
		}
		
		@RosettaAttribute("ctrctVal")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrctVal")
		@Override
		public ContractValuationData8__2.ContractValuationData8__2Builder setCtrctVal(AmountAndDirection109__2 _ctrctVal) {
			this.ctrctVal = _ctrctVal == null ? null : _ctrctVal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tmStmp")
		@Override
		public ContractValuationData8__2.ContractValuationData8__2Builder setTmStmp(ZonedDateTime _tmStmp) {
			this.tmStmp = _tmStmp == null ? null : _tmStmp;
			return this;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public ContractValuationData8__2.ContractValuationData8__2Builder setTp(ValuationType1Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@RosettaAttribute("dlta")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dlta")
		@Override
		public ContractValuationData8__2.ContractValuationData8__2Builder setDlta(BigDecimal _dlta) {
			this.dlta = _dlta == null ? null : _dlta;
			return this;
		}
		
		@Override
		public ContractValuationData8__2 build() {
			return new ContractValuationData8__2.ContractValuationData8__2Impl(this);
		}
		
		@Override
		public ContractValuationData8__2.ContractValuationData8__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractValuationData8__2.ContractValuationData8__2Builder prune() {
			if (ctrctVal!=null && !ctrctVal.prune().hasData()) ctrctVal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtrctVal()!=null && getCtrctVal().hasData()) return true;
			if (getTmStmp()!=null) return true;
			if (getTp()!=null) return true;
			if (getDlta()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractValuationData8__2.ContractValuationData8__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractValuationData8__2.ContractValuationData8__2Builder o = (ContractValuationData8__2.ContractValuationData8__2Builder) other;
			
			merger.mergeRosetta(getCtrctVal(), o.getCtrctVal(), this::setCtrctVal);
			
			merger.mergeBasic(getTmStmp(), o.getTmStmp(), this::setTmStmp);
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			merger.mergeBasic(getDlta(), o.getDlta(), this::setDlta);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractValuationData8__2 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctVal, _that.getCtrctVal())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			if (!Objects.equals(tp, _that.getTp())) return false;
			if (!Objects.equals(dlta, _that.getDlta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctVal != null ? ctrctVal.hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dlta != null ? dlta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractValuationData8__2Builder {" +
				"ctrctVal=" + this.ctrctVal + ", " +
				"tmStmp=" + this.tmStmp + ", " +
				"tp=" + this.tp + ", " +
				"dlta=" + this.dlta +
			'}';
		}
	}
}
