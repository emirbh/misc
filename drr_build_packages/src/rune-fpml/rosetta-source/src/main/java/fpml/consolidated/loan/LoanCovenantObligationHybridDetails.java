package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.loan.meta.LoanCovenantObligationHybridDetailsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure to describe the hybrid target criteria of a covenant obligation.
 *
 */
@RosettaDataType(value="LoanCovenantObligationHybridDetails", builder=LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationHybridDetails", model="fpml", builder=LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationHybridDetails extends RosettaModelObject {

	LoanCovenantObligationHybridDetailsMeta metaData = new LoanCovenantObligationHybridDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the date or frequency by which a covenant obligation must be met.
	 *
	 */
	List<? extends LoanCovenantObligationDateTriggerDetails> getDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the metric value criteria of a covenant obligation.
	 *
	 */
	LoanCovenantObligationMetric getMetric();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationHybridDetails build();
	
	LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder toBuilder();
	
	static LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder builder() {
		return new LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationHybridDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationHybridDetails> getType() {
		return LoanCovenantObligationHybridDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("date"), processor, LoanCovenantObligationDateTriggerDetails.class, getDate());
		processRosetta(path.newSubPath("metric"), processor, LoanCovenantObligationMetric.class, getMetric());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationHybridDetailsBuilder extends LoanCovenantObligationHybridDetails, RosettaModelObjectBuilder {
		LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder getOrCreateDate(int index);
		@Override
		List<? extends LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder> getDate();
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder getOrCreateMetric();
		@Override
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder getMetric();
		LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder addDate(LoanCovenantObligationDateTriggerDetails date);
		LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder addDate(LoanCovenantObligationDateTriggerDetails date, int idx);
		LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder addDate(List<? extends LoanCovenantObligationDateTriggerDetails> date);
		LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder setDate(List<? extends LoanCovenantObligationDateTriggerDetails> date);
		LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder setMetric(LoanCovenantObligationMetric metric);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("date"), processor, LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder.class, getDate());
			processRosetta(path.newSubPath("metric"), processor, LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder.class, getMetric());
		}
		

		LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationHybridDetails  ***********************/
	class LoanCovenantObligationHybridDetailsImpl implements LoanCovenantObligationHybridDetails {
		private final List<? extends LoanCovenantObligationDateTriggerDetails> date;
		private final LoanCovenantObligationMetric metric;
		
		protected LoanCovenantObligationHybridDetailsImpl(LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder builder) {
			this.date = ofNullable(builder.getDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.metric = ofNullable(builder.getMetric()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("date")
		public List<? extends LoanCovenantObligationDateTriggerDetails> getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("metric")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("metric")
		public LoanCovenantObligationMetric getMetric() {
			return metric;
		}
		
		@Override
		public LoanCovenantObligationHybridDetails build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder toBuilder() {
			LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getMetric()).ifPresent(builder::setMetric);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationHybridDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(date, _that.getDate())) return false;
			if (!Objects.equals(metric, _that.getMetric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (metric != null ? metric.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationHybridDetails {" +
				"date=" + this.date + ", " +
				"metric=" + this.metric +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationHybridDetails  ***********************/
	class LoanCovenantObligationHybridDetailsBuilderImpl implements LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder {
	
		protected List<LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder> date = new ArrayList<>();
		protected LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder metric;
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("date")
		public List<? extends LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder> getDate() {
			return date;
		}
		
		@Override
		public LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder getOrCreateDate(int index) {
			if (date==null) {
				this.date = new ArrayList<>();
			}
			return getIndex(date, index, () -> {
						LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder newDate = LoanCovenantObligationDateTriggerDetails.builder();
						return newDate;
					});
		}
		
		@Override
		@RosettaAttribute("metric")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("metric")
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder getMetric() {
			return metric;
		}
		
		@Override
		public LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder getOrCreateMetric() {
			LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder result;
			if (metric!=null) {
				result = metric;
			}
			else {
				result = metric = LoanCovenantObligationMetric.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("date")
		@Override
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder addDate(LoanCovenantObligationDateTriggerDetails _date) {
			if (_date != null) {
				this.date.add(_date.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder addDate(LoanCovenantObligationDateTriggerDetails _date, int idx) {
			getIndex(this.date, idx, () -> _date.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder addDate(List<? extends LoanCovenantObligationDateTriggerDetails> dates) {
			if (dates != null) {
				for (final LoanCovenantObligationDateTriggerDetails toAdd : dates) {
					this.date.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("date")
		@Override
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder setDate(List<? extends LoanCovenantObligationDateTriggerDetails> dates) {
			if (dates == null) {
				this.date = new ArrayList<>();
			} else {
				this.date = dates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("metric")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("metric")
		@Override
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder setMetric(LoanCovenantObligationMetric _metric) {
			this.metric = _metric == null ? null : _metric.toBuilder();
			return this;
		}
		
		@Override
		public LoanCovenantObligationHybridDetails build() {
			return new LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsImpl(this);
		}
		
		@Override
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder prune() {
			date = date.stream().filter(b->b!=null).<LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (metric!=null && !metric.prune().hasData()) metric = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null && getDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMetric()!=null && getMetric().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder o = (LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder) other;
			
			merger.mergeRosetta(getDate(), o.getDate(), this::getOrCreateDate);
			merger.mergeRosetta(getMetric(), o.getMetric(), this::setMetric);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationHybridDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(date, _that.getDate())) return false;
			if (!Objects.equals(metric, _that.getMetric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (metric != null ? metric.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationHybridDetailsBuilder {" +
				"date=" + this.date + ", " +
				"metric=" + this.metric +
			'}';
		}
	}
}
