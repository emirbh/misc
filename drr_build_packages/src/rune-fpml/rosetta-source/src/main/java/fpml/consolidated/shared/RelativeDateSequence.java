package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.RelativeDateSequenceMeta;
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
 * Provision A type describing a date when this date is defined in reference to another date through one or several date offsets.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing a date when this date is defined in reference to another date through one or several date offsets.
 *
 */
@RosettaDataType(value="RelativeDateSequence", builder=RelativeDateSequence.RelativeDateSequenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RelativeDateSequence", model="fpml", builder=RelativeDateSequence.RelativeDateSequenceBuilderImpl.class, version="2.1.1")
public interface RelativeDateSequence extends RosettaModelObject {

	RelativeDateSequenceMeta metaData = new RelativeDateSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the anchor as an href attribute. The href attribute value is a pointer style reference to the element or component elsewhere in the document where the anchor date is defined.
	 *
	 */
	DateReference getDateRelativeTo();
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
	List<? extends DateOffset> getDateOffset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a set of financial business centers defined elsewhere in the document. This set of business centers is used to determine whether a particular day is a business day or not.
	 *
	 */
	BusinessCentersReference getBusinessCentersReference();
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
	BusinessCenters getBusinessCenters();

	/*********************** Build Methods  ***********************/
	RelativeDateSequence build();
	
	RelativeDateSequence.RelativeDateSequenceBuilder toBuilder();
	
	static RelativeDateSequence.RelativeDateSequenceBuilder builder() {
		return new RelativeDateSequence.RelativeDateSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RelativeDateSequence> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RelativeDateSequence> getType() {
		return RelativeDateSequence.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.class, getDateRelativeTo());
		processRosetta(path.newSubPath("dateOffset"), processor, DateOffset.class, getDateOffset());
		processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.class, getBusinessCentersReference());
		processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.class, getBusinessCenters());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RelativeDateSequenceBuilder extends RelativeDateSequence, RosettaModelObjectBuilder {
		DateReference.DateReferenceBuilder getOrCreateDateRelativeTo();
		@Override
		DateReference.DateReferenceBuilder getDateRelativeTo();
		DateOffset.DateOffsetBuilder getOrCreateDateOffset(int index);
		@Override
		List<? extends DateOffset.DateOffsetBuilder> getDateOffset();
		BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference();
		@Override
		BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference();
		BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters();
		@Override
		BusinessCenters.BusinessCentersBuilder getBusinessCenters();
		RelativeDateSequence.RelativeDateSequenceBuilder setDateRelativeTo(DateReference dateRelativeTo);
		RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(DateOffset dateOffset);
		RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(DateOffset dateOffset, int idx);
		RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(List<? extends DateOffset> dateOffset);
		RelativeDateSequence.RelativeDateSequenceBuilder setDateOffset(List<? extends DateOffset> dateOffset);
		RelativeDateSequence.RelativeDateSequenceBuilder setBusinessCentersReference(BusinessCentersReference businessCentersReference);
		RelativeDateSequence.RelativeDateSequenceBuilder setBusinessCenters(BusinessCenters businessCenters);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.DateReferenceBuilder.class, getDateRelativeTo());
			processRosetta(path.newSubPath("dateOffset"), processor, DateOffset.DateOffsetBuilder.class, getDateOffset());
			processRosetta(path.newSubPath("businessCentersReference"), processor, BusinessCentersReference.BusinessCentersReferenceBuilder.class, getBusinessCentersReference());
			processRosetta(path.newSubPath("businessCenters"), processor, BusinessCenters.BusinessCentersBuilder.class, getBusinessCenters());
		}
		

		RelativeDateSequence.RelativeDateSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of RelativeDateSequence  ***********************/
	class RelativeDateSequenceImpl implements RelativeDateSequence {
		private final DateReference dateRelativeTo;
		private final List<? extends DateOffset> dateOffset;
		private final BusinessCentersReference businessCentersReference;
		private final BusinessCenters businessCenters;
		
		protected RelativeDateSequenceImpl(RelativeDateSequence.RelativeDateSequenceBuilder builder) {
			this.dateRelativeTo = ofNullable(builder.getDateRelativeTo()).map(f->f.build()).orElse(null);
			this.dateOffset = ofNullable(builder.getDateOffset()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.businessCentersReference = ofNullable(builder.getBusinessCentersReference()).map(f->f.build()).orElse(null);
			this.businessCenters = ofNullable(builder.getBusinessCenters()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateRelativeTo")
		public DateReference getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		@RosettaAttribute("dateOffset")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dateOffset")
		public List<? extends DateOffset> getDateOffset() {
			return dateOffset;
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCentersReference")
		public BusinessCentersReference getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public RelativeDateSequence build() {
			return this;
		}
		
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder toBuilder() {
			RelativeDateSequence.RelativeDateSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RelativeDateSequence.RelativeDateSequenceBuilder builder) {
			ofNullable(getDateRelativeTo()).ifPresent(builder::setDateRelativeTo);
			ofNullable(getDateOffset()).ifPresent(builder::setDateOffset);
			ofNullable(getBusinessCentersReference()).ifPresent(builder::setBusinessCentersReference);
			ofNullable(getBusinessCenters()).ifPresent(builder::setBusinessCenters);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelativeDateSequence _that = getType().cast(o);
		
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!ListEquals.listEquals(dateOffset, _that.getDateOffset())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (dateOffset != null ? dateOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateSequence {" +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"dateOffset=" + this.dateOffset + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters +
			'}';
		}
	}

	/*********************** Builder Implementation of RelativeDateSequence  ***********************/
	class RelativeDateSequenceBuilderImpl implements RelativeDateSequence.RelativeDateSequenceBuilder {
	
		protected DateReference.DateReferenceBuilder dateRelativeTo;
		protected List<DateOffset.DateOffsetBuilder> dateOffset = new ArrayList<>();
		protected BusinessCentersReference.BusinessCentersReferenceBuilder businessCentersReference;
		protected BusinessCenters.BusinessCentersBuilder businessCenters;
		
		@Override
		@RosettaAttribute("dateRelativeTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateRelativeTo")
		public DateReference.DateReferenceBuilder getDateRelativeTo() {
			return dateRelativeTo;
		}
		
		@Override
		public DateReference.DateReferenceBuilder getOrCreateDateRelativeTo() {
			DateReference.DateReferenceBuilder result;
			if (dateRelativeTo!=null) {
				result = dateRelativeTo;
			}
			else {
				result = dateRelativeTo = DateReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateOffset")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dateOffset")
		public List<? extends DateOffset.DateOffsetBuilder> getDateOffset() {
			return dateOffset;
		}
		
		@Override
		public DateOffset.DateOffsetBuilder getOrCreateDateOffset(int index) {
			if (dateOffset==null) {
				this.dateOffset = new ArrayList<>();
			}
			return getIndex(dateOffset, index, () -> {
						DateOffset.DateOffsetBuilder newDateOffset = DateOffset.builder();
						return newDateOffset;
					});
		}
		
		@Override
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCentersReference")
		public BusinessCentersReference.BusinessCentersReferenceBuilder getBusinessCentersReference() {
			return businessCentersReference;
		}
		
		@Override
		public BusinessCentersReference.BusinessCentersReferenceBuilder getOrCreateBusinessCentersReference() {
			BusinessCentersReference.BusinessCentersReferenceBuilder result;
			if (businessCentersReference!=null) {
				result = businessCentersReference;
			}
			else {
				result = businessCentersReference = BusinessCentersReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("businessCenters")
		public BusinessCenters.BusinessCentersBuilder getBusinessCenters() {
			return businessCenters;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateBusinessCenters() {
			BusinessCenters.BusinessCentersBuilder result;
			if (businessCenters!=null) {
				result = businessCenters;
			}
			else {
				result = businessCenters = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("dateRelativeTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateRelativeTo")
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder setDateRelativeTo(DateReference _dateRelativeTo) {
			this.dateRelativeTo = _dateRelativeTo == null ? null : _dateRelativeTo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateOffset")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dateOffset")
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(DateOffset _dateOffset) {
			if (_dateOffset != null) {
				this.dateOffset.add(_dateOffset.toBuilder());
			}
			return this;
		}
		
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(DateOffset _dateOffset, int idx) {
			getIndex(this.dateOffset, idx, () -> _dateOffset.toBuilder());
			return this;
		}
		
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder addDateOffset(List<? extends DateOffset> dateOffsets) {
			if (dateOffsets != null) {
				for (final DateOffset toAdd : dateOffsets) {
					this.dateOffset.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dateOffset")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dateOffset")
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder setDateOffset(List<? extends DateOffset> dateOffsets) {
			if (dateOffsets == null) {
				this.dateOffset = new ArrayList<>();
			} else {
				this.dateOffset = dateOffsets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("businessCentersReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCentersReference")
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder setBusinessCentersReference(BusinessCentersReference _businessCentersReference) {
			this.businessCentersReference = _businessCentersReference == null ? null : _businessCentersReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("businessCenters")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("businessCenters")
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder setBusinessCenters(BusinessCenters _businessCenters) {
			this.businessCenters = _businessCenters == null ? null : _businessCenters.toBuilder();
			return this;
		}
		
		@Override
		public RelativeDateSequence build() {
			return new RelativeDateSequence.RelativeDateSequenceImpl(this);
		}
		
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder prune() {
			if (dateRelativeTo!=null && !dateRelativeTo.prune().hasData()) dateRelativeTo = null;
			dateOffset = dateOffset.stream().filter(b->b!=null).<DateOffset.DateOffsetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (businessCentersReference!=null && !businessCentersReference.prune().hasData()) businessCentersReference = null;
			if (businessCenters!=null && !businessCenters.prune().hasData()) businessCenters = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDateRelativeTo()!=null && getDateRelativeTo().hasData()) return true;
			if (getDateOffset()!=null && getDateOffset().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBusinessCentersReference()!=null && getBusinessCentersReference().hasData()) return true;
			if (getBusinessCenters()!=null && getBusinessCenters().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RelativeDateSequence.RelativeDateSequenceBuilder o = (RelativeDateSequence.RelativeDateSequenceBuilder) other;
			
			merger.mergeRosetta(getDateRelativeTo(), o.getDateRelativeTo(), this::setDateRelativeTo);
			merger.mergeRosetta(getDateOffset(), o.getDateOffset(), this::getOrCreateDateOffset);
			merger.mergeRosetta(getBusinessCentersReference(), o.getBusinessCentersReference(), this::setBusinessCentersReference);
			merger.mergeRosetta(getBusinessCenters(), o.getBusinessCenters(), this::setBusinessCenters);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RelativeDateSequence _that = getType().cast(o);
		
			if (!Objects.equals(dateRelativeTo, _that.getDateRelativeTo())) return false;
			if (!ListEquals.listEquals(dateOffset, _that.getDateOffset())) return false;
			if (!Objects.equals(businessCentersReference, _that.getBusinessCentersReference())) return false;
			if (!Objects.equals(businessCenters, _that.getBusinessCenters())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dateRelativeTo != null ? dateRelativeTo.hashCode() : 0);
			_result = 31 * _result + (dateOffset != null ? dateOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersReference != null ? businessCentersReference.hashCode() : 0);
			_result = 31 * _result + (businessCenters != null ? businessCenters.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RelativeDateSequenceBuilder {" +
				"dateRelativeTo=" + this.dateRelativeTo + ", " +
				"dateOffset=" + this.dateOffset + ", " +
				"businessCentersReference=" + this.businessCentersReference + ", " +
				"businessCenters=" + this.businessCenters +
			'}';
		}
	}
}
