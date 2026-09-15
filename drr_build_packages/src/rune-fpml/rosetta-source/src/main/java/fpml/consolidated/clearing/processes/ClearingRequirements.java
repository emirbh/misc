package fpml.consolidated.clearing.processes;

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
import fpml.consolidated.clearing.processes.meta.ClearingRequirementsMeta;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.shared.SupervisoryBody;
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
 * Provision 
 *
 */
@RosettaDataType(value="ClearingRequirements", builder=ClearingRequirements.ClearingRequirementsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ClearingRequirements", model="fpml", builder=ClearingRequirements.ClearingRequirementsBuilderImpl.class, version="2.1.1")
public interface ClearingRequirements extends RosettaModelObject {

	ClearingRequirementsMeta metaData = new ClearingRequirementsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The regulator or other supervisory body to which the clearing requirements apply.
	 *
	 */
	SupervisoryBody getSupervisoryBody();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether the particular trade type in question is required by this regulator to be cleared.
	 *
	 */
	Boolean getMandatorilyClearable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates a reason supporting why the trade is mandatorily clearable or not.
	 *
	 */
	List<? extends Reason> getReason();

	/*********************** Build Methods  ***********************/
	ClearingRequirements build();
	
	ClearingRequirements.ClearingRequirementsBuilder toBuilder();
	
	static ClearingRequirements.ClearingRequirementsBuilder builder() {
		return new ClearingRequirements.ClearingRequirementsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingRequirements> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingRequirements> getType() {
		return ClearingRequirements.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("supervisoryBody"), processor, SupervisoryBody.class, getSupervisoryBody());
		processor.processBasic(path.newSubPath("mandatorilyClearable"), Boolean.class, getMandatorilyClearable(), this);
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingRequirementsBuilder extends ClearingRequirements, RosettaModelObjectBuilder {
		SupervisoryBody.SupervisoryBodyBuilder getOrCreateSupervisoryBody();
		@Override
		SupervisoryBody.SupervisoryBodyBuilder getSupervisoryBody();
		Reason.ReasonBuilder getOrCreateReason(int index);
		@Override
		List<? extends Reason.ReasonBuilder> getReason();
		ClearingRequirements.ClearingRequirementsBuilder setSupervisoryBody(SupervisoryBody supervisoryBody);
		ClearingRequirements.ClearingRequirementsBuilder setMandatorilyClearable(Boolean mandatorilyClearable);
		ClearingRequirements.ClearingRequirementsBuilder addReason(Reason reason);
		ClearingRequirements.ClearingRequirementsBuilder addReason(Reason reason, int idx);
		ClearingRequirements.ClearingRequirementsBuilder addReason(List<? extends Reason> reason);
		ClearingRequirements.ClearingRequirementsBuilder setReason(List<? extends Reason> reason);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("supervisoryBody"), processor, SupervisoryBody.SupervisoryBodyBuilder.class, getSupervisoryBody());
			processor.processBasic(path.newSubPath("mandatorilyClearable"), Boolean.class, getMandatorilyClearable(), this);
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
		}
		

		ClearingRequirements.ClearingRequirementsBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingRequirements  ***********************/
	class ClearingRequirementsImpl implements ClearingRequirements {
		private final SupervisoryBody supervisoryBody;
		private final Boolean mandatorilyClearable;
		private final List<? extends Reason> reason;
		
		protected ClearingRequirementsImpl(ClearingRequirements.ClearingRequirementsBuilder builder) {
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).map(f->f.build()).orElse(null);
			this.mandatorilyClearable = builder.getMandatorilyClearable();
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("supervisoryBody")
		public SupervisoryBody getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("mandatorilyClearable")
		public Boolean getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		public ClearingRequirements build() {
			return this;
		}
		
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder toBuilder() {
			ClearingRequirements.ClearingRequirementsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingRequirements.ClearingRequirementsBuilder builder) {
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getMandatorilyClearable()).ifPresent(builder::setMandatorilyClearable);
			ofNullable(getReason()).ifPresent(builder::setReason);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingRequirements _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingRequirements {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"reason=" + this.reason +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingRequirements  ***********************/
	class ClearingRequirementsBuilderImpl implements ClearingRequirements.ClearingRequirementsBuilder {
	
		protected SupervisoryBody.SupervisoryBodyBuilder supervisoryBody;
		protected Boolean mandatorilyClearable;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("supervisoryBody")
		public SupervisoryBody.SupervisoryBodyBuilder getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		public SupervisoryBody.SupervisoryBodyBuilder getOrCreateSupervisoryBody() {
			SupervisoryBody.SupervisoryBodyBuilder result;
			if (supervisoryBody!=null) {
				result = supervisoryBody;
			}
			else {
				result = supervisoryBody = SupervisoryBody.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("mandatorilyClearable")
		public Boolean getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		@Override
		public Reason.ReasonBuilder getOrCreateReason(int index) {
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			return getIndex(reason, index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("supervisoryBody")
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder setSupervisoryBody(SupervisoryBody _supervisoryBody) {
			this.supervisoryBody = _supervisoryBody == null ? null : _supervisoryBody.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("mandatorilyClearable")
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder setMandatorilyClearable(Boolean _mandatorilyClearable) {
			this.mandatorilyClearable = _mandatorilyClearable == null ? null : _mandatorilyClearable;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (final Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null) {
				this.reason = new ArrayList<>();
			} else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ClearingRequirements build() {
			return new ClearingRequirements.ClearingRequirementsImpl(this);
		}
		
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder prune() {
			if (supervisoryBody!=null && !supervisoryBody.prune().hasData()) supervisoryBody = null;
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSupervisoryBody()!=null && getSupervisoryBody().hasData()) return true;
			if (getMandatorilyClearable()!=null) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingRequirements.ClearingRequirementsBuilder o = (ClearingRequirements.ClearingRequirementsBuilder) other;
			
			merger.mergeRosetta(getSupervisoryBody(), o.getSupervisoryBody(), this::setSupervisoryBody);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			
			merger.mergeBasic(getMandatorilyClearable(), o.getMandatorilyClearable(), this::setMandatorilyClearable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingRequirements _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingRequirementsBuilder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"reason=" + this.reason +
			'}';
		}
	}
}
