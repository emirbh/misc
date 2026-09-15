package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.ApprovalsMeta;
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
@RosettaDataType(value="Approvals", builder=Approvals.ApprovalsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Approvals", model="fpml", builder=Approvals.ApprovalsBuilderImpl.class, version="2.1.1")
public interface Approvals extends RosettaModelObject {

	ApprovalsMeta metaData = new ApprovalsMeta();

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
	List<? extends Approval> getApproval();

	/*********************** Build Methods  ***********************/
	Approvals build();
	
	Approvals.ApprovalsBuilder toBuilder();
	
	static Approvals.ApprovalsBuilder builder() {
		return new Approvals.ApprovalsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Approvals> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Approvals> getType() {
		return Approvals.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("approval"), processor, Approval.class, getApproval());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApprovalsBuilder extends Approvals, RosettaModelObjectBuilder {
		Approval.ApprovalBuilder getOrCreateApproval(int index);
		@Override
		List<? extends Approval.ApprovalBuilder> getApproval();
		Approvals.ApprovalsBuilder addApproval(Approval approval);
		Approvals.ApprovalsBuilder addApproval(Approval approval, int idx);
		Approvals.ApprovalsBuilder addApproval(List<? extends Approval> approval);
		Approvals.ApprovalsBuilder setApproval(List<? extends Approval> approval);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("approval"), processor, Approval.ApprovalBuilder.class, getApproval());
		}
		

		Approvals.ApprovalsBuilder prune();
	}

	/*********************** Immutable Implementation of Approvals  ***********************/
	class ApprovalsImpl implements Approvals {
		private final List<? extends Approval> approval;
		
		protected ApprovalsImpl(Approvals.ApprovalsBuilder builder) {
			this.approval = ofNullable(builder.getApproval()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("approval")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("approval")
		public List<? extends Approval> getApproval() {
			return approval;
		}
		
		@Override
		public Approvals build() {
			return this;
		}
		
		@Override
		public Approvals.ApprovalsBuilder toBuilder() {
			Approvals.ApprovalsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Approvals.ApprovalsBuilder builder) {
			ofNullable(getApproval()).ifPresent(builder::setApproval);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Approvals _that = getType().cast(o);
		
			if (!ListEquals.listEquals(approval, _that.getApproval())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (approval != null ? approval.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Approvals {" +
				"approval=" + this.approval +
			'}';
		}
	}

	/*********************** Builder Implementation of Approvals  ***********************/
	class ApprovalsBuilderImpl implements Approvals.ApprovalsBuilder {
	
		protected List<Approval.ApprovalBuilder> approval = new ArrayList<>();
		
		@Override
		@RosettaAttribute("approval")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("approval")
		public List<? extends Approval.ApprovalBuilder> getApproval() {
			return approval;
		}
		
		@Override
		public Approval.ApprovalBuilder getOrCreateApproval(int index) {
			if (approval==null) {
				this.approval = new ArrayList<>();
			}
			return getIndex(approval, index, () -> {
						Approval.ApprovalBuilder newApproval = Approval.builder();
						return newApproval;
					});
		}
		
		@RosettaAttribute("approval")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("approval")
		@Override
		public Approvals.ApprovalsBuilder addApproval(Approval _approval) {
			if (_approval != null) {
				this.approval.add(_approval.toBuilder());
			}
			return this;
		}
		
		@Override
		public Approvals.ApprovalsBuilder addApproval(Approval _approval, int idx) {
			getIndex(this.approval, idx, () -> _approval.toBuilder());
			return this;
		}
		
		@Override
		public Approvals.ApprovalsBuilder addApproval(List<? extends Approval> approvals) {
			if (approvals != null) {
				for (final Approval toAdd : approvals) {
					this.approval.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("approval")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("approval")
		@Override
		public Approvals.ApprovalsBuilder setApproval(List<? extends Approval> approvals) {
			if (approvals == null) {
				this.approval = new ArrayList<>();
			} else {
				this.approval = approvals.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Approvals build() {
			return new Approvals.ApprovalsImpl(this);
		}
		
		@Override
		public Approvals.ApprovalsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Approvals.ApprovalsBuilder prune() {
			approval = approval.stream().filter(b->b!=null).<Approval.ApprovalBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApproval()!=null && getApproval().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Approvals.ApprovalsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Approvals.ApprovalsBuilder o = (Approvals.ApprovalsBuilder) other;
			
			merger.mergeRosetta(getApproval(), o.getApproval(), this::getOrCreateApproval);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Approvals _that = getType().cast(o);
		
			if (!ListEquals.listEquals(approval, _that.getApproval())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (approval != null ? approval.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApprovalsBuilder {" +
				"approval=" + this.approval +
			'}';
		}
	}
}
