package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.FloatingRate13__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRate13__1", builder=FloatingRate13__1.FloatingRate13__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="FloatingRate13__1", model="iso20022", builder=FloatingRate13__1.FloatingRate13__1BuilderImpl.class, version="${project.version}")
public interface FloatingRate13__1 extends RosettaModelObject {

	FloatingRate13__1Meta metaData = new FloatingRate13__1Meta();

	/*********************** Getter Methods  ***********************/
	SecuritiesTransactionPrice20Choice__1 getSprd();
	InterestComputationMethodFormat7__1 getDayCnt();
	InterestRateFrequency3Choice__1 getPmtFrqcy();

	/*********************** Build Methods  ***********************/
	FloatingRate13__1 build();
	
	FloatingRate13__1.FloatingRate13__1Builder toBuilder();
	
	static FloatingRate13__1.FloatingRate13__1Builder builder() {
		return new FloatingRate13__1.FloatingRate13__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRate13__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRate13__1> getType() {
		return FloatingRate13__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("sprd"), processor, SecuritiesTransactionPrice20Choice__1.class, getSprd());
		processRosetta(path.newSubPath("dayCnt"), processor, InterestComputationMethodFormat7__1.class, getDayCnt());
		processRosetta(path.newSubPath("pmtFrqcy"), processor, InterestRateFrequency3Choice__1.class, getPmtFrqcy());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRate13__1Builder extends FloatingRate13__1, RosettaModelObjectBuilder {
		SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getOrCreateSprd();
		@Override
		SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getSprd();
		InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder getOrCreateDayCnt();
		@Override
		InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder getDayCnt();
		InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder getOrCreatePmtFrqcy();
		@Override
		InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder getPmtFrqcy();
		FloatingRate13__1.FloatingRate13__1Builder setSprd(SecuritiesTransactionPrice20Choice__1 sprd);
		FloatingRate13__1.FloatingRate13__1Builder setDayCnt(InterestComputationMethodFormat7__1 dayCnt);
		FloatingRate13__1.FloatingRate13__1Builder setPmtFrqcy(InterestRateFrequency3Choice__1 pmtFrqcy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("sprd"), processor, SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder.class, getSprd());
			processRosetta(path.newSubPath("dayCnt"), processor, InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder.class, getDayCnt());
			processRosetta(path.newSubPath("pmtFrqcy"), processor, InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder.class, getPmtFrqcy());
		}
		

		FloatingRate13__1.FloatingRate13__1Builder prune();
	}

	/*********************** Immutable Implementation of FloatingRate13__1  ***********************/
	class FloatingRate13__1Impl implements FloatingRate13__1 {
		private final SecuritiesTransactionPrice20Choice__1 sprd;
		private final InterestComputationMethodFormat7__1 dayCnt;
		private final InterestRateFrequency3Choice__1 pmtFrqcy;
		
		protected FloatingRate13__1Impl(FloatingRate13__1.FloatingRate13__1Builder builder) {
			this.sprd = ofNullable(builder.getSprd()).map(f->f.build()).orElse(null);
			this.dayCnt = ofNullable(builder.getDayCnt()).map(f->f.build()).orElse(null);
			this.pmtFrqcy = ofNullable(builder.getPmtFrqcy()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("sprd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sprd")
		public SecuritiesTransactionPrice20Choice__1 getSprd() {
			return sprd;
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
		public FloatingRate13__1 build() {
			return this;
		}
		
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder toBuilder() {
			FloatingRate13__1.FloatingRate13__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRate13__1.FloatingRate13__1Builder builder) {
			ofNullable(getSprd()).ifPresent(builder::setSprd);
			ofNullable(getDayCnt()).ifPresent(builder::setDayCnt);
			ofNullable(getPmtFrqcy()).ifPresent(builder::setPmtFrqcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRate13__1 _that = getType().cast(o);
		
			if (!Objects.equals(sprd, _that.getSprd())) return false;
			if (!Objects.equals(dayCnt, _that.getDayCnt())) return false;
			if (!Objects.equals(pmtFrqcy, _that.getPmtFrqcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sprd != null ? sprd.hashCode() : 0);
			_result = 31 * _result + (dayCnt != null ? dayCnt.hashCode() : 0);
			_result = 31 * _result + (pmtFrqcy != null ? pmtFrqcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate13__1 {" +
				"sprd=" + this.sprd + ", " +
				"dayCnt=" + this.dayCnt + ", " +
				"pmtFrqcy=" + this.pmtFrqcy +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRate13__1  ***********************/
	class FloatingRate13__1BuilderImpl implements FloatingRate13__1.FloatingRate13__1Builder {
	
		protected SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder sprd;
		protected InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder dayCnt;
		protected InterestRateFrequency3Choice__1.InterestRateFrequency3Choice__1Builder pmtFrqcy;
		
		@Override
		@RosettaAttribute("sprd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sprd")
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getSprd() {
			return sprd;
		}
		
		@Override
		public SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder getOrCreateSprd() {
			SecuritiesTransactionPrice20Choice__1.SecuritiesTransactionPrice20Choice__1Builder result;
			if (sprd!=null) {
				result = sprd;
			}
			else {
				result = sprd = SecuritiesTransactionPrice20Choice__1.builder();
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
		
		@RosettaAttribute("sprd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sprd")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder setSprd(SecuritiesTransactionPrice20Choice__1 _sprd) {
			this.sprd = _sprd == null ? null : _sprd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dayCnt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCnt")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder setDayCnt(InterestComputationMethodFormat7__1 _dayCnt) {
			this.dayCnt = _dayCnt == null ? null : _dayCnt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pmtFrqcy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pmtFrqcy")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder setPmtFrqcy(InterestRateFrequency3Choice__1 _pmtFrqcy) {
			this.pmtFrqcy = _pmtFrqcy == null ? null : _pmtFrqcy.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRate13__1 build() {
			return new FloatingRate13__1.FloatingRate13__1Impl(this);
		}
		
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder prune() {
			if (sprd!=null && !sprd.prune().hasData()) sprd = null;
			if (dayCnt!=null && !dayCnt.prune().hasData()) dayCnt = null;
			if (pmtFrqcy!=null && !pmtFrqcy.prune().hasData()) pmtFrqcy = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSprd()!=null && getSprd().hasData()) return true;
			if (getDayCnt()!=null && getDayCnt().hasData()) return true;
			if (getPmtFrqcy()!=null && getPmtFrqcy().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate13__1.FloatingRate13__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRate13__1.FloatingRate13__1Builder o = (FloatingRate13__1.FloatingRate13__1Builder) other;
			
			merger.mergeRosetta(getSprd(), o.getSprd(), this::setSprd);
			merger.mergeRosetta(getDayCnt(), o.getDayCnt(), this::setDayCnt);
			merger.mergeRosetta(getPmtFrqcy(), o.getPmtFrqcy(), this::setPmtFrqcy);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRate13__1 _that = getType().cast(o);
		
			if (!Objects.equals(sprd, _that.getSprd())) return false;
			if (!Objects.equals(dayCnt, _that.getDayCnt())) return false;
			if (!Objects.equals(pmtFrqcy, _that.getPmtFrqcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sprd != null ? sprd.hashCode() : 0);
			_result = 31 * _result + (dayCnt != null ? dayCnt.hashCode() : 0);
			_result = 31 * _result + (pmtFrqcy != null ? pmtFrqcy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate13__1Builder {" +
				"sprd=" + this.sprd + ", " +
				"dayCnt=" + this.dayCnt + ", " +
				"pmtFrqcy=" + this.pmtFrqcy +
			'}';
		}
	}
}
