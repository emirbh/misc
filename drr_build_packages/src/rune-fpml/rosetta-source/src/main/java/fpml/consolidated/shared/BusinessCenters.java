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
import fpml.consolidated.shared.meta.BusinessCentersMeta;
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
 * Provision A type for defining business day calendar used in determining whether a day is a business day or not. A list of business day calendar locations may be ordered in the document alphabetically based on business day calendar location code. An FpML document containing an unordered business day calendar location list is still regarded as a conformant document.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type for defining business day calendar used in determining whether a day is a business day or not. A list of business day calendar locations may be ordered in the document alphabetically based on business day calendar location code. An FpML document containing an unordered business day calendar location list is still regarded as a conformant document.
 *
 */
@RosettaDataType(value="BusinessCenters", builder=BusinessCenters.BusinessCentersBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BusinessCenters", model="fpml", builder=BusinessCenters.BusinessCentersBuilderImpl.class, version="2.1.1")
public interface BusinessCenters extends RosettaModelObject {

	BusinessCentersMeta metaData = new BusinessCentersMeta();

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
	List<? extends BusinessCenter> getBusinessCenter();

	/*********************** Build Methods  ***********************/
	BusinessCenters build();
	
	BusinessCenters.BusinessCentersBuilder toBuilder();
	
	static BusinessCenters.BusinessCentersBuilder builder() {
		return new BusinessCenters.BusinessCentersBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BusinessCenters> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BusinessCenters> getType() {
		return BusinessCenters.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.class, getBusinessCenter());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BusinessCentersBuilder extends BusinessCenters, RosettaModelObjectBuilder {
		BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter(int index);
		@Override
		List<? extends BusinessCenter.BusinessCenterBuilder> getBusinessCenter();
		BusinessCenters.BusinessCentersBuilder setId(String id);
		BusinessCenters.BusinessCentersBuilder addBusinessCenter(BusinessCenter businessCenter);
		BusinessCenters.BusinessCentersBuilder addBusinessCenter(BusinessCenter businessCenter, int idx);
		BusinessCenters.BusinessCentersBuilder addBusinessCenter(List<? extends BusinessCenter> businessCenter);
		BusinessCenters.BusinessCentersBuilder setBusinessCenter(List<? extends BusinessCenter> businessCenter);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.BusinessCenterBuilder.class, getBusinessCenter());
		}
		

		BusinessCenters.BusinessCentersBuilder prune();
	}

	/*********************** Immutable Implementation of BusinessCenters  ***********************/
	class BusinessCentersImpl implements BusinessCenters {
		private final String id;
		private final List<? extends BusinessCenter> businessCenter;
		
		protected BusinessCentersImpl(BusinessCenters.BusinessCentersBuilder builder) {
			this.id = builder.getId();
			this.businessCenter = ofNullable(builder.getBusinessCenter()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("businessCenter")
		public List<? extends BusinessCenter> getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public BusinessCenters build() {
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder toBuilder() {
			BusinessCenters.BusinessCentersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BusinessCenters.BusinessCentersBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenters _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(businessCenter, _that.getBusinessCenter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCenters {" +
				"id=" + this.id + ", " +
				"businessCenter=" + this.businessCenter +
			'}';
		}
	}

	/*********************** Builder Implementation of BusinessCenters  ***********************/
	class BusinessCentersBuilderImpl implements BusinessCenters.BusinessCentersBuilder {
	
		protected String id;
		protected List<BusinessCenter.BusinessCenterBuilder> businessCenter = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("businessCenter")
		public List<? extends BusinessCenter.BusinessCenterBuilder> getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter(int index) {
			if (businessCenter==null) {
				this.businessCenter = new ArrayList<>();
			}
			return getIndex(businessCenter, index, () -> {
						BusinessCenter.BusinessCenterBuilder newBusinessCenter = BusinessCenter.builder();
						return newBusinessCenter;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public BusinessCenters.BusinessCentersBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("businessCenter")
		@Override
		public BusinessCenters.BusinessCentersBuilder addBusinessCenter(BusinessCenter _businessCenter) {
			if (_businessCenter != null) {
				this.businessCenter.add(_businessCenter.toBuilder());
			}
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder addBusinessCenter(BusinessCenter _businessCenter, int idx) {
			getIndex(this.businessCenter, idx, () -> _businessCenter.toBuilder());
			return this;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder addBusinessCenter(List<? extends BusinessCenter> businessCenters) {
			if (businessCenters != null) {
				for (final BusinessCenter toAdd : businessCenters) {
					this.businessCenter.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("businessCenter")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("businessCenter")
		@Override
		public BusinessCenters.BusinessCentersBuilder setBusinessCenter(List<? extends BusinessCenter> businessCenters) {
			if (businessCenters == null) {
				this.businessCenter = new ArrayList<>();
			} else {
				this.businessCenter = businessCenters.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public BusinessCenters build() {
			return new BusinessCenters.BusinessCentersImpl(this);
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenters.BusinessCentersBuilder prune() {
			businessCenter = businessCenter.stream().filter(b->b!=null).<BusinessCenter.BusinessCenterBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getBusinessCenter()!=null && getBusinessCenter().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BusinessCenters.BusinessCentersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BusinessCenters.BusinessCentersBuilder o = (BusinessCenters.BusinessCentersBuilder) other;
			
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::getOrCreateBusinessCenter);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BusinessCenters _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(businessCenter, _that.getBusinessCenter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BusinessCentersBuilder {" +
				"id=" + this.id + ", " +
				"businessCenter=" + this.businessCenter +
			'}';
		}
	}
}
