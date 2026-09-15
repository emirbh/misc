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
import iso20022.auth030.mas.meta.ContractValuationData8__1Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ContractValuationData8__1", builder=ContractValuationData8__1.ContractValuationData8__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ContractValuationData8__1", model="iso20022", builder=ContractValuationData8__1.ContractValuationData8__1BuilderImpl.class, version="${project.version}")
public interface ContractValuationData8__1 extends RosettaModelObject {

	ContractValuationData8__1Meta metaData = new ContractValuationData8__1Meta();

	/*********************** Getter Methods  ***********************/
	AmountAndDirection109__1 getCtrctVal();
	ZonedDateTime getTmStmp();
	ValuationType1Code getTp();

	/*********************** Build Methods  ***********************/
	ContractValuationData8__1 build();
	
	ContractValuationData8__1.ContractValuationData8__1Builder toBuilder();
	
	static ContractValuationData8__1.ContractValuationData8__1Builder builder() {
		return new ContractValuationData8__1.ContractValuationData8__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractValuationData8__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ContractValuationData8__1> getType() {
		return ContractValuationData8__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrctVal"), processor, AmountAndDirection109__1.class, getCtrctVal());
		processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
		processor.processBasic(path.newSubPath("tp"), ValuationType1Code.class, getTp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractValuationData8__1Builder extends ContractValuationData8__1, RosettaModelObjectBuilder {
		AmountAndDirection109__1.AmountAndDirection109__1Builder getOrCreateCtrctVal();
		@Override
		AmountAndDirection109__1.AmountAndDirection109__1Builder getCtrctVal();
		ContractValuationData8__1.ContractValuationData8__1Builder setCtrctVal(AmountAndDirection109__1 ctrctVal);
		ContractValuationData8__1.ContractValuationData8__1Builder setTmStmp(ZonedDateTime tmStmp);
		ContractValuationData8__1.ContractValuationData8__1Builder setTp(ValuationType1Code tp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrctVal"), processor, AmountAndDirection109__1.AmountAndDirection109__1Builder.class, getCtrctVal());
			processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
			processor.processBasic(path.newSubPath("tp"), ValuationType1Code.class, getTp(), this);
		}
		

		ContractValuationData8__1.ContractValuationData8__1Builder prune();
	}

	/*********************** Immutable Implementation of ContractValuationData8__1  ***********************/
	class ContractValuationData8__1Impl implements ContractValuationData8__1 {
		private final AmountAndDirection109__1 ctrctVal;
		private final ZonedDateTime tmStmp;
		private final ValuationType1Code tp;
		
		protected ContractValuationData8__1Impl(ContractValuationData8__1.ContractValuationData8__1Builder builder) {
			this.ctrctVal = ofNullable(builder.getCtrctVal()).map(f->f.build()).orElse(null);
			this.tmStmp = builder.getTmStmp();
			this.tp = builder.getTp();
		}
		
		@Override
		@RosettaAttribute("ctrctVal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrctVal")
		public AmountAndDirection109__1 getCtrctVal() {
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
		public ContractValuationData8__1 build() {
			return this;
		}
		
		@Override
		public ContractValuationData8__1.ContractValuationData8__1Builder toBuilder() {
			ContractValuationData8__1.ContractValuationData8__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractValuationData8__1.ContractValuationData8__1Builder builder) {
			ofNullable(getCtrctVal()).ifPresent(builder::setCtrctVal);
			ofNullable(getTmStmp()).ifPresent(builder::setTmStmp);
			ofNullable(getTp()).ifPresent(builder::setTp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractValuationData8__1 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctVal, _that.getCtrctVal())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			if (!Objects.equals(tp, _that.getTp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctVal != null ? ctrctVal.hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractValuationData8__1 {" +
				"ctrctVal=" + this.ctrctVal + ", " +
				"tmStmp=" + this.tmStmp + ", " +
				"tp=" + this.tp +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractValuationData8__1  ***********************/
	class ContractValuationData8__1BuilderImpl implements ContractValuationData8__1.ContractValuationData8__1Builder {
	
		protected AmountAndDirection109__1.AmountAndDirection109__1Builder ctrctVal;
		protected ZonedDateTime tmStmp;
		protected ValuationType1Code tp;
		
		@Override
		@RosettaAttribute("ctrctVal")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrctVal")
		public AmountAndDirection109__1.AmountAndDirection109__1Builder getCtrctVal() {
			return ctrctVal;
		}
		
		@Override
		public AmountAndDirection109__1.AmountAndDirection109__1Builder getOrCreateCtrctVal() {
			AmountAndDirection109__1.AmountAndDirection109__1Builder result;
			if (ctrctVal!=null) {
				result = ctrctVal;
			}
			else {
				result = ctrctVal = AmountAndDirection109__1.builder();
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
		
		@RosettaAttribute("ctrctVal")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrctVal")
		@Override
		public ContractValuationData8__1.ContractValuationData8__1Builder setCtrctVal(AmountAndDirection109__1 _ctrctVal) {
			this.ctrctVal = _ctrctVal == null ? null : _ctrctVal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tmStmp")
		@Override
		public ContractValuationData8__1.ContractValuationData8__1Builder setTmStmp(ZonedDateTime _tmStmp) {
			this.tmStmp = _tmStmp == null ? null : _tmStmp;
			return this;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public ContractValuationData8__1.ContractValuationData8__1Builder setTp(ValuationType1Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@Override
		public ContractValuationData8__1 build() {
			return new ContractValuationData8__1.ContractValuationData8__1Impl(this);
		}
		
		@Override
		public ContractValuationData8__1.ContractValuationData8__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractValuationData8__1.ContractValuationData8__1Builder prune() {
			if (ctrctVal!=null && !ctrctVal.prune().hasData()) ctrctVal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtrctVal()!=null && getCtrctVal().hasData()) return true;
			if (getTmStmp()!=null) return true;
			if (getTp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractValuationData8__1.ContractValuationData8__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractValuationData8__1.ContractValuationData8__1Builder o = (ContractValuationData8__1.ContractValuationData8__1Builder) other;
			
			merger.mergeRosetta(getCtrctVal(), o.getCtrctVal(), this::setCtrctVal);
			
			merger.mergeBasic(getTmStmp(), o.getTmStmp(), this::setTmStmp);
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractValuationData8__1 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctVal, _that.getCtrctVal())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			if (!Objects.equals(tp, _that.getTp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctVal != null ? ctrctVal.hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractValuationData8__1Builder {" +
				"ctrctVal=" + this.ctrctVal + ", " +
				"tmStmp=" + this.tmStmp + ", " +
				"tp=" + this.tp +
			'}';
		}
	}
}
