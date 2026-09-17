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
import fpml.consolidated.shared.meta.AdjustableDatesMeta;
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
 * Provision A type for defining a series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the dates.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining a series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the dates.
 *
 */
@RosettaDataType(value="AdjustableDates", builder=AdjustableDates.AdjustableDatesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdjustableDates", model="fpml", builder=AdjustableDates.AdjustableDatesBuilderImpl.class, version="2.1.1")
public interface AdjustableDates extends RosettaModelObject {

	AdjustableDatesMeta metaData = new AdjustableDatesMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A date subject to adjustment.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A date subject to adjustment.
	 *
	 */
	List<? extends IdentifiedDate> getUnadjustedDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business dat in the specified business centers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business dat in the specified business centers.
	 *
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
	 *
	 */
	List<? extends IdentifiedDate> getAdjustedDate();

	/*********************** Build Methods  ***********************/
	AdjustableDates build();
	
	AdjustableDates.AdjustableDatesBuilder toBuilder();
	
	static AdjustableDates.AdjustableDatesBuilder builder() {
		return new AdjustableDates.AdjustableDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableDates> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdjustableDates> getType() {
		return AdjustableDates.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.class, getUnadjustedDate());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableDatesBuilder extends AdjustableDates, RosettaModelObjectBuilder {
		IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedDate(int index);
		@Override
		List<? extends IdentifiedDate.IdentifiedDateBuilder> getUnadjustedDate();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate(int index);
		@Override
		List<? extends IdentifiedDate.IdentifiedDateBuilder> getAdjustedDate();
		AdjustableDates.AdjustableDatesBuilder setId(String id);
		AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(IdentifiedDate unadjustedDate);
		AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(IdentifiedDate unadjustedDate, int idx);
		AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(List<? extends IdentifiedDate> unadjustedDate);
		AdjustableDates.AdjustableDatesBuilder setUnadjustedDate(List<? extends IdentifiedDate> unadjustedDate);
		AdjustableDates.AdjustableDatesBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDate(IdentifiedDate adjustedDate);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDate(IdentifiedDate adjustedDate, int idx);
		AdjustableDates.AdjustableDatesBuilder addAdjustedDate(List<? extends IdentifiedDate> adjustedDate);
		AdjustableDates.AdjustableDatesBuilder setAdjustedDate(List<? extends IdentifiedDate> adjustedDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("unadjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getUnadjustedDate());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
		}
		

		AdjustableDates.AdjustableDatesBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableDates  ***********************/
	class AdjustableDatesImpl implements AdjustableDates {
		private final String id;
		private final List<? extends IdentifiedDate> unadjustedDate;
		private final BusinessDayAdjustments dateAdjustments;
		private final List<? extends IdentifiedDate> adjustedDate;
		
		protected AdjustableDatesImpl(AdjustableDates.AdjustableDatesBuilder builder) {
			this.id = builder.getId();
			this.unadjustedDate = ofNullable(builder.getUnadjustedDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.adjustedDate = ofNullable(builder.getAdjustedDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("unadjustedDate")
		public List<? extends IdentifiedDate> getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("adjustedDate")
		public List<? extends IdentifiedDate> getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public AdjustableDates build() {
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder toBuilder() {
			AdjustableDates.AdjustableDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableDates.AdjustableDatesBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getUnadjustedDate()).ifPresent(builder::setUnadjustedDate);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getAdjustedDate()).ifPresent(builder::setAdjustedDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDates {" +
				"id=" + this.id + ", " +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableDates  ***********************/
	class AdjustableDatesBuilderImpl implements AdjustableDates.AdjustableDatesBuilder {
	
		protected String id;
		protected List<IdentifiedDate.IdentifiedDateBuilder> unadjustedDate = new ArrayList<>();
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected List<IdentifiedDate.IdentifiedDateBuilder> adjustedDate = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("unadjustedDate")
		public List<? extends IdentifiedDate.IdentifiedDateBuilder> getUnadjustedDate() {
			return unadjustedDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateUnadjustedDate(int index) {
			if (unadjustedDate==null) {
				this.unadjustedDate = new ArrayList<>();
			}
			return getIndex(unadjustedDate, index, () -> {
						IdentifiedDate.IdentifiedDateBuilder newUnadjustedDate = IdentifiedDate.builder();
						return newUnadjustedDate;
					});
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("adjustedDate")
		public List<? extends IdentifiedDate.IdentifiedDateBuilder> getAdjustedDate() {
			return adjustedDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateAdjustedDate(int index) {
			if (adjustedDate==null) {
				this.adjustedDate = new ArrayList<>();
			}
			return getIndex(adjustedDate, index, () -> {
						IdentifiedDate.IdentifiedDateBuilder newAdjustedDate = IdentifiedDate.builder();
						return newAdjustedDate;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public AdjustableDates.AdjustableDatesBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("unadjustedDate")
		@Override
		public AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(IdentifiedDate _unadjustedDate) {
			if (_unadjustedDate != null) {
				this.unadjustedDate.add(_unadjustedDate.toBuilder());
			}
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(IdentifiedDate _unadjustedDate, int idx) {
			getIndex(this.unadjustedDate, idx, () -> _unadjustedDate.toBuilder());
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder addUnadjustedDate(List<? extends IdentifiedDate> unadjustedDates) {
			if (unadjustedDates != null) {
				for (final IdentifiedDate toAdd : unadjustedDates) {
					this.unadjustedDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("unadjustedDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("unadjustedDate")
		@Override
		public AdjustableDates.AdjustableDatesBuilder setUnadjustedDate(List<? extends IdentifiedDate> unadjustedDates) {
			if (unadjustedDates == null) {
				this.unadjustedDate = new ArrayList<>();
			} else {
				this.unadjustedDate = unadjustedDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public AdjustableDates.AdjustableDatesBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("adjustedDate")
		@Override
		public AdjustableDates.AdjustableDatesBuilder addAdjustedDate(IdentifiedDate _adjustedDate) {
			if (_adjustedDate != null) {
				this.adjustedDate.add(_adjustedDate.toBuilder());
			}
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder addAdjustedDate(IdentifiedDate _adjustedDate, int idx) {
			getIndex(this.adjustedDate, idx, () -> _adjustedDate.toBuilder());
			return this;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder addAdjustedDate(List<? extends IdentifiedDate> adjustedDates) {
			if (adjustedDates != null) {
				for (final IdentifiedDate toAdd : adjustedDates) {
					this.adjustedDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("adjustedDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("adjustedDate")
		@Override
		public AdjustableDates.AdjustableDatesBuilder setAdjustedDate(List<? extends IdentifiedDate> adjustedDates) {
			if (adjustedDates == null) {
				this.adjustedDate = new ArrayList<>();
			} else {
				this.adjustedDate = adjustedDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AdjustableDates build() {
			return new AdjustableDates.AdjustableDatesImpl(this);
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDates.AdjustableDatesBuilder prune() {
			unadjustedDate = unadjustedDate.stream().filter(b->b!=null).<IdentifiedDate.IdentifiedDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			adjustedDate = adjustedDate.stream().filter(b->b!=null).<IdentifiedDate.IdentifiedDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getUnadjustedDate()!=null && getUnadjustedDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getAdjustedDate()!=null && getAdjustedDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableDates.AdjustableDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableDates.AdjustableDatesBuilder o = (AdjustableDates.AdjustableDatesBuilder) other;
			
			merger.mergeRosetta(getUnadjustedDate(), o.getUnadjustedDate(), this::getOrCreateUnadjustedDate);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getAdjustedDate(), o.getAdjustedDate(), this::getOrCreateAdjustedDate);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableDates _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(unadjustedDate, _that.getUnadjustedDate())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!ListEquals.listEquals(adjustedDate, _that.getAdjustedDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (unadjustedDate != null ? unadjustedDate.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (adjustedDate != null ? adjustedDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableDatesBuilder {" +
				"id=" + this.id + ", " +
				"unadjustedDate=" + this.unadjustedDate + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"adjustedDate=" + this.adjustedDate +
			'}';
		}
	}
}
