package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.IndexChangeMeta;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
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
 * version "recordkeeping-5.13"
 *
 * Provision A structure describing the effect of a change to an index.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing the effect of a change to an index.
 *
 */
@RosettaDataType(value="IndexChange", builder=IndexChange.IndexChangeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IndexChange", model="fpml", builder=IndexChange.IndexChangeBuilderImpl.class, version="2.1.1")
public interface IndexChange extends ChangeEvent {

	IndexChangeMeta metaData = new IndexChangeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	BigDecimal getIndexFactor();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Money getFactoredCalculationAmount();

	/*********************** Build Methods  ***********************/
	IndexChange build();
	
	IndexChange.IndexChangeBuilder toBuilder();
	
	static IndexChange.IndexChangeBuilder builder() {
		return new IndexChange.IndexChangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexChange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IndexChange> getType() {
		return IndexChange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
		processRosetta(path.newSubPath("factoredCalculationAmount"), processor, Money.class, getFactoredCalculationAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexChangeBuilder extends IndexChange, ChangeEvent.ChangeEventBuilder {
		Money.MoneyBuilder getOrCreateFactoredCalculationAmount();
		@Override
		Money.MoneyBuilder getFactoredCalculationAmount();
		@Override
		IndexChange.IndexChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		IndexChange.IndexChangeBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		IndexChange.IndexChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		IndexChange.IndexChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		IndexChange.IndexChangeBuilder setIndexFactor(BigDecimal indexFactor);
		IndexChange.IndexChangeBuilder setFactoredCalculationAmount(Money factoredCalculationAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processor.processBasic(path.newSubPath("indexFactor"), BigDecimal.class, getIndexFactor(), this);
			processRosetta(path.newSubPath("factoredCalculationAmount"), processor, Money.MoneyBuilder.class, getFactoredCalculationAmount());
		}
		

		IndexChange.IndexChangeBuilder prune();
	}

	/*********************** Immutable Implementation of IndexChange  ***********************/
	class IndexChangeImpl extends ChangeEvent.ChangeEventImpl implements IndexChange {
		private final BigDecimal indexFactor;
		private final Money factoredCalculationAmount;
		
		protected IndexChangeImpl(IndexChange.IndexChangeBuilder builder) {
			super(builder);
			this.indexFactor = builder.getIndexFactor();
			this.factoredCalculationAmount = ofNullable(builder.getFactoredCalculationAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("factoredCalculationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("factoredCalculationAmount")
		public Money getFactoredCalculationAmount() {
			return factoredCalculationAmount;
		}
		
		@Override
		public IndexChange build() {
			return this;
		}
		
		@Override
		public IndexChange.IndexChangeBuilder toBuilder() {
			IndexChange.IndexChangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexChange.IndexChangeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIndexFactor()).ifPresent(builder::setIndexFactor);
			ofNullable(getFactoredCalculationAmount()).ifPresent(builder::setFactoredCalculationAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndexChange _that = getType().cast(o);
		
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(factoredCalculationAmount, _that.getFactoredCalculationAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (factoredCalculationAmount != null ? factoredCalculationAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexChange {" +
				"indexFactor=" + this.indexFactor + ", " +
				"factoredCalculationAmount=" + this.factoredCalculationAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of IndexChange  ***********************/
	class IndexChangeBuilderImpl extends ChangeEvent.ChangeEventBuilderImpl implements IndexChange.IndexChangeBuilder {
	
		protected BigDecimal indexFactor;
		protected Money.MoneyBuilder factoredCalculationAmount;
		
		@Override
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexFactor")
		public BigDecimal getIndexFactor() {
			return indexFactor;
		}
		
		@Override
		@RosettaAttribute("factoredCalculationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("factoredCalculationAmount")
		public Money.MoneyBuilder getFactoredCalculationAmount() {
			return factoredCalculationAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateFactoredCalculationAmount() {
			Money.MoneyBuilder result;
			if (factoredCalculationAmount!=null) {
				result = factoredCalculationAmount;
			}
			else {
				result = factoredCalculationAmount = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public IndexChange.IndexChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public IndexChange.IndexChangeBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public IndexChange.IndexChangeBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public IndexChange.IndexChangeBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("indexFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexFactor")
		@Override
		public IndexChange.IndexChangeBuilder setIndexFactor(BigDecimal _indexFactor) {
			this.indexFactor = _indexFactor == null ? null : _indexFactor;
			return this;
		}
		
		@RosettaAttribute("factoredCalculationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("factoredCalculationAmount")
		@Override
		public IndexChange.IndexChangeBuilder setFactoredCalculationAmount(Money _factoredCalculationAmount) {
			this.factoredCalculationAmount = _factoredCalculationAmount == null ? null : _factoredCalculationAmount.toBuilder();
			return this;
		}
		
		@Override
		public IndexChange build() {
			return new IndexChange.IndexChangeImpl(this);
		}
		
		@Override
		public IndexChange.IndexChangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexChange.IndexChangeBuilder prune() {
			super.prune();
			if (factoredCalculationAmount!=null && !factoredCalculationAmount.prune().hasData()) factoredCalculationAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIndexFactor()!=null) return true;
			if (getFactoredCalculationAmount()!=null && getFactoredCalculationAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexChange.IndexChangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			IndexChange.IndexChangeBuilder o = (IndexChange.IndexChangeBuilder) other;
			
			merger.mergeRosetta(getFactoredCalculationAmount(), o.getFactoredCalculationAmount(), this::setFactoredCalculationAmount);
			
			merger.mergeBasic(getIndexFactor(), o.getIndexFactor(), this::setIndexFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			IndexChange _that = getType().cast(o);
		
			if (!Objects.equals(indexFactor, _that.getIndexFactor())) return false;
			if (!Objects.equals(factoredCalculationAmount, _that.getFactoredCalculationAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (indexFactor != null ? indexFactor.hashCode() : 0);
			_result = 31 * _result + (factoredCalculationAmount != null ? factoredCalculationAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexChangeBuilder {" +
				"indexFactor=" + this.indexFactor + ", " +
				"factoredCalculationAmount=" + this.factoredCalculationAmount +
			'}' + " " + super.toString();
		}
	}
}
