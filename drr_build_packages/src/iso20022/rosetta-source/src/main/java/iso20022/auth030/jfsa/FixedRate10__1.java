package iso20022.auth030.jfsa;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.jfsa.meta.FixedRate10__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FixedRate10__1", builder=FixedRate10__1.FixedRate10__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FixedRate10__1", model="iso20022", builder=FixedRate10__1.FixedRate10__1BuilderImpl.class, version="${project.version}")
public interface FixedRate10__1 extends RosettaModelObject {

	FixedRate10__1Meta metaData = new FixedRate10__1Meta();

	/*********************** Getter Methods  ***********************/
	SecuritiesTransactionPrice14Choice__1 getRate();
	InterestComputationMethodFormat7__1 getDayCnt();
	InterestRateFrequency3Choice__1 getPmtFrqcy();

	/*********************** Build Methods  ***********************/
	FixedRate10__1 build();
	
	FixedRate10__1.FixedRate10__1Builder toBuilder();
	
	static FixedRate10__1.FixedRate10__1Builder builder() {
		return new FixedRate10__1.FixedRate10__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FixedRate10__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FixedRate10__1> getType() {
		return FixedRate10__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rate"), processor, SecuritiesTransactionPrice14Choice__1.class, getRate());
		processRosetta(path.newSubPath("dayCnt"), processor, InterestComputationMethodFormat7__1.class, getDayCnt());
		processRosetta(path.newSubPath("pmtFrqcy"), processor, InterestRateFrequency3Choice__1.class, getPmtFrqcy());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FixedRate10__1Builder extends FixedRate10__1, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder getOrCreateRate();
		@Override
		SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder getRate();
		InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder getOrCreateDayCnt();
		@Override
		InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder getDayCnt();
		InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder getOrCreatePmtFrqcy();
		@Override
		InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder getPmtFrqcy();
		FixedRate10__1.FixedRate10__1Builder setRate(SecuritiesTransactionPrice14Choice__1 rate);
		FixedRate10__1.FixedRate10__1Builder setDayCnt(InterestComputationMethodFormat7__1 dayCnt);
		FixedRate10__1.FixedRate10__1Builder setPmtFrqcy(InterestRateFrequency3Choice__1 pmtFrqcy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rate"), processor, SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder.class, getRate());
			processRosetta(path.newSubPath("dayCnt"), processor, InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder.class, getDayCnt());
			processRosetta(path.newSubPath("pmtFrqcy"), processor, InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder.class, getPmtFrqcy());
		}
		

		FixedRate10__1.FixedRate10__1Builder prune();
	}

	/*********************** Immutable Implementation of FixedRate10__1  ***********************/
	class FixedRate10__1Impl implements FixedRate10__1 {
		private final SecuritiesTransactionPrice14Choice__1 rate;
		private final InterestComputationMethodFormat7__1 dayCnt;
		private final InterestRateFrequency3Choice__1 pmtFrqcy;
		
		protected FixedRate10__1Impl(FixedRate10__1.FixedRate10__1Builder builder) {
			this.rate = ofNullable(builder.getRate()).map(f->f.build()).orElse(null);
			this.dayCnt = ofNullable(builder.getDayCnt()).map(f->f.build()).orElse(null);
			this.pmtFrqcy = ofNullable(builder.getPmtFrqcy()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rate")
		public SecuritiesTransactionPrice14Choice__1 getRate() {
			return rate;
		}
		
		@Override
		@RosettaAttribute("dayCnt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCnt")
		public InterestComputationMethodFormat7__1 getDayCnt() {
			return dayCnt;
		}
		
		@Override
		@RosettaAttribute("pmtFrqcy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtFrqcy")
		public InterestRateFrequency3Choice__1 getPmtFrqcy() {
			return pmtFrqcy;
		}
		
		@Override
		public FixedRate10__1 build() {
			return this;
		}
		
		@Override
		public FixedRate10__1.FixedRate10__1Builder toBuilder() {
			FixedRate10__1.FixedRate10__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FixedRate10__1.FixedRate10__1Builder builder) {
			ofNullable(getRate()).ifPresent(builder::setRate);
			ofNullable(getDayCnt()).ifPresent(builder::setDayCnt);
			ofNullable(getPmtFrqcy()).ifPresent(builder::setPmtFrqcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedRate10__1 _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(dayCnt, _that.getDayCnt())) return false;
			if (!Objects.equals(pmtFrqcy, _that.getPmtFrqcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (dayCnt != null ? dayCnt.hashCode() : 0);
			_result = 31 * _result + (pmtFrqcy != null ? pmtFrqcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRate10__1 {" +
				"rate=" + this.rate + ", " +
				"dayCnt=" + this.dayCnt + ", " +
				"pmtFrqcy=" + this.pmtFrqcy +
			'}';
		}
	}

	/*********************** Builder Implementation of FixedRate10__1  ***********************/
	class FixedRate10__1BuilderImpl implements FixedRate10__1.FixedRate10__1Builder {
	
		protected SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder rate;
		protected InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder dayCnt;
		protected InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder pmtFrqcy;
		
		@Override
		@RosettaAttribute("rate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rate")
		public SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder getRate() {
			return rate;
		}
		
		@Override
		public SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder getOrCreateRate() {
			SecuritiesTransactionPrice14Choice__1.SecuritiesTransactionPrice14Choice__1Builder result;
			if (rate!=null) {
				result = rate;
			}
			else {
				result = rate = SecuritiesTransactionPrice14Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dayCnt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCnt")
		public InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder getDayCnt() {
			return dayCnt;
		}
		
		@Override
		public InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder getOrCreateDayCnt() {
			InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder result;
			if (dayCnt!=null) {
				result = dayCnt;
			}
			else {
				result = dayCnt = InterestComputationMethodFormat7__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pmtFrqcy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pmtFrqcy")
		public InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder getPmtFrqcy() {
			return pmtFrqcy;
		}
		
		@Override
		public InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder getOrCreatePmtFrqcy() {
			InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder result;
			if (pmtFrqcy!=null) {
				result = pmtFrqcy;
			}
			else {
				result = pmtFrqcy = InterestRateFrequency3Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("rate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rate")
		@Override
		public FixedRate10__1.FixedRate10__1Builder setRate(SecuritiesTransactionPrice14Choice__1 _rate) {
			this.rate = _rate == null ? null : _rate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCnt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCnt")
		@Override
		public FixedRate10__1.FixedRate10__1Builder setDayCnt(InterestComputationMethodFormat7__1 _dayCnt) {
			this.dayCnt = _dayCnt == null ? null : _dayCnt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pmtFrqcy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pmtFrqcy")
		@Override
		public FixedRate10__1.FixedRate10__1Builder setPmtFrqcy(InterestRateFrequency3Choice__1 _pmtFrqcy) {
			this.pmtFrqcy = _pmtFrqcy == null ? null : _pmtFrqcy.toBuilder();
			return this;
		}
		
		@Override
		public FixedRate10__1 build() {
			return new FixedRate10__1.FixedRate10__1Impl(this);
		}
		
		@Override
		public FixedRate10__1.FixedRate10__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRate10__1.FixedRate10__1Builder prune() {
			if (rate!=null && !rate.prune().hasData()) rate = null;
			if (dayCnt!=null && !dayCnt.prune().hasData()) dayCnt = null;
			if (pmtFrqcy!=null && !pmtFrqcy.prune().hasData()) pmtFrqcy = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRate()!=null && getRate().hasData()) return true;
			if (getDayCnt()!=null && getDayCnt().hasData()) return true;
			if (getPmtFrqcy()!=null && getPmtFrqcy().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FixedRate10__1.FixedRate10__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FixedRate10__1.FixedRate10__1Builder o = (FixedRate10__1.FixedRate10__1Builder) other;
			
			merger.mergeRosetta(getRate(), o.getRate(), this::setRate);
			merger.mergeRosetta(getDayCnt(), o.getDayCnt(), this::setDayCnt);
			merger.mergeRosetta(getPmtFrqcy(), o.getPmtFrqcy(), this::setPmtFrqcy);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FixedRate10__1 _that = getType().cast(o);
		
			if (!Objects.equals(rate, _that.getRate())) return false;
			if (!Objects.equals(dayCnt, _that.getDayCnt())) return false;
			if (!Objects.equals(pmtFrqcy, _that.getPmtFrqcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rate != null ? rate.hashCode() : 0);
			_result = 31 * _result + (dayCnt != null ? dayCnt.hashCode() : 0);
			_result = 31 * _result + (pmtFrqcy != null ? pmtFrqcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FixedRate10__1Builder {" +
				"rate=" + this.rate + ", " +
				"dayCnt=" + this.dayCnt + ", " +
				"pmtFrqcy=" + this.pmtFrqcy +
			'}';
		}
	}
}
