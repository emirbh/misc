package fpml.consolidated.loan;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.loan.meta.LoanCovenantObligationTriggerCriteriaDetailsMeta;
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
 * Provision A structure to describe the trigger criteria of a covenant obligation.
 *
 */
@RosettaDataType(value="LoanCovenantObligationTriggerCriteriaDetails", builder=LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationTriggerCriteriaDetails", model="fpml", builder=LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationTriggerCriteriaDetails extends RosettaModelObject {

	LoanCovenantObligationTriggerCriteriaDetailsMeta metaData = new LoanCovenantObligationTriggerCriteriaDetailsMeta();

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
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure to describe the hybrid trigger criteria of a covenant obligation.
	 *
	 */
	LoanCovenantObligationHybridDetails getHybridCriteria();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationTriggerCriteriaDetails build();
	
	LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder toBuilder();
	
	static LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder builder() {
		return new LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationTriggerCriteriaDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationTriggerCriteriaDetails> getType() {
		return LoanCovenantObligationTriggerCriteriaDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("date"), processor, LoanCovenantObligationDateTriggerDetails.class, getDate());
		processRosetta(path.newSubPath("metric"), processor, LoanCovenantObligationMetric.class, getMetric());
		processRosetta(path.newSubPath("hybridCriteria"), processor, LoanCovenantObligationHybridDetails.class, getHybridCriteria());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationTriggerCriteriaDetailsBuilder extends LoanCovenantObligationTriggerCriteriaDetails, RosettaModelObjectBuilder {
		LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder getOrCreateDate(int index);
		@Override
		List<? extends LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder> getDate();
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder getOrCreateMetric();
		@Override
		LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder getMetric();
		LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder getOrCreateHybridCriteria();
		@Override
		LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder getHybridCriteria();
		LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder addDate(LoanCovenantObligationDateTriggerDetails date);
		LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder addDate(LoanCovenantObligationDateTriggerDetails date, int idx);
		LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder addDate(List<? extends LoanCovenantObligationDateTriggerDetails> date);
		LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder setDate(List<? extends LoanCovenantObligationDateTriggerDetails> date);
		LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder setMetric(LoanCovenantObligationMetric metric);
		LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder setHybridCriteria(LoanCovenantObligationHybridDetails hybridCriteria);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("date"), processor, LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder.class, getDate());
			processRosetta(path.newSubPath("metric"), processor, LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder.class, getMetric());
			processRosetta(path.newSubPath("hybridCriteria"), processor, LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder.class, getHybridCriteria());
		}
		

		LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationTriggerCriteriaDetails  ***********************/
	class LoanCovenantObligationTriggerCriteriaDetailsImpl implements LoanCovenantObligationTriggerCriteriaDetails {
		private final List<? extends LoanCovenantObligationDateTriggerDetails> date;
		private final LoanCovenantObligationMetric metric;
		private final LoanCovenantObligationHybridDetails hybridCriteria;
		
		protected LoanCovenantObligationTriggerCriteriaDetailsImpl(LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder builder) {
			this.date = ofNullable(builder.getDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.metric = ofNullable(builder.getMetric()).map(f->f.build()).orElse(null);
			this.hybridCriteria = ofNullable(builder.getHybridCriteria()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("date")
		public List<? extends LoanCovenantObligationDateTriggerDetails> getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("metric")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("metric")
		public LoanCovenantObligationMetric getMetric() {
			return metric;
		}
		
		@Override
		@RosettaAttribute("hybridCriteria")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hybridCriteria")
		public LoanCovenantObligationHybridDetails getHybridCriteria() {
			return hybridCriteria;
		}
		
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder toBuilder() {
			LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getMetric()).ifPresent(builder::setMetric);
			ofNullable(getHybridCriteria()).ifPresent(builder::setHybridCriteria);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationTriggerCriteriaDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(date, _that.getDate())) return false;
			if (!Objects.equals(metric, _that.getMetric())) return false;
			if (!Objects.equals(hybridCriteria, _that.getHybridCriteria())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (metric != null ? metric.hashCode() : 0);
			_result = 31 * _result + (hybridCriteria != null ? hybridCriteria.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationTriggerCriteriaDetails {" +
				"date=" + this.date + ", " +
				"metric=" + this.metric + ", " +
				"hybridCriteria=" + this.hybridCriteria +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationTriggerCriteriaDetails  ***********************/
	class LoanCovenantObligationTriggerCriteriaDetailsBuilderImpl implements LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder {
	
		protected List<LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder> date = new ArrayList<>();
		protected LoanCovenantObligationMetric.LoanCovenantObligationMetricBuilder metric;
		protected LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder hybridCriteria;
		
		@Override
		@RosettaAttribute("date")
		@Accessor(AccessorType.GETTER)
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
		
		@Override
		@RosettaAttribute("hybridCriteria")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hybridCriteria")
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder getHybridCriteria() {
			return hybridCriteria;
		}
		
		@Override
		public LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder getOrCreateHybridCriteria() {
			LoanCovenantObligationHybridDetails.LoanCovenantObligationHybridDetailsBuilder result;
			if (hybridCriteria!=null) {
				result = hybridCriteria;
			}
			else {
				result = hybridCriteria = LoanCovenantObligationHybridDetails.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("date")
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder addDate(LoanCovenantObligationDateTriggerDetails _date) {
			if (_date != null) {
				this.date.add(_date.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder addDate(LoanCovenantObligationDateTriggerDetails _date, int idx) {
			getIndex(this.date, idx, () -> _date.toBuilder());
			return this;
		}
		
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder addDate(List<? extends LoanCovenantObligationDateTriggerDetails> dates) {
			if (dates != null) {
				for (final LoanCovenantObligationDateTriggerDetails toAdd : dates) {
					this.date.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("date")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("date")
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder setDate(List<? extends LoanCovenantObligationDateTriggerDetails> dates) {
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
		@RuneAttribute("metric")
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder setMetric(LoanCovenantObligationMetric _metric) {
			this.metric = _metric == null ? null : _metric.toBuilder();
			return this;
		}
		
		@RosettaAttribute("hybridCriteria")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("hybridCriteria")
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder setHybridCriteria(LoanCovenantObligationHybridDetails _hybridCriteria) {
			this.hybridCriteria = _hybridCriteria == null ? null : _hybridCriteria.toBuilder();
			return this;
		}
		
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails build() {
			return new LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsImpl(this);
		}
		
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder prune() {
			date = date.stream().filter(b->b!=null).<LoanCovenantObligationDateTriggerDetails.LoanCovenantObligationDateTriggerDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (metric!=null && !metric.prune().hasData()) metric = null;
			if (hybridCriteria!=null && !hybridCriteria.prune().hasData()) hybridCriteria = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null && getDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMetric()!=null && getMetric().hasData()) return true;
			if (getHybridCriteria()!=null && getHybridCriteria().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder o = (LoanCovenantObligationTriggerCriteriaDetails.LoanCovenantObligationTriggerCriteriaDetailsBuilder) other;
			
			merger.mergeRosetta(getDate(), o.getDate(), this::getOrCreateDate);
			merger.mergeRosetta(getMetric(), o.getMetric(), this::setMetric);
			merger.mergeRosetta(getHybridCriteria(), o.getHybridCriteria(), this::setHybridCriteria);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationTriggerCriteriaDetails _that = getType().cast(o);
		
			if (!ListEquals.listEquals(date, _that.getDate())) return false;
			if (!Objects.equals(metric, _that.getMetric())) return false;
			if (!Objects.equals(hybridCriteria, _that.getHybridCriteria())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (metric != null ? metric.hashCode() : 0);
			_result = 31 * _result + (hybridCriteria != null ? hybridCriteria.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationTriggerCriteriaDetailsBuilder {" +
				"date=" + this.date + ", " +
				"metric=" + this.metric + ", " +
				"hybridCriteria=" + this.hybridCriteria +
			'}';
		}
	}
}
