package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.legaldocumentation.csa.meta.IneligibleCreditSupportMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the parties to which the provisions of the Credit Support Annex for Variation Margin will apply to.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
 * paragraph "13" * clause "(c)(iii)" * name "Legally Ineligible Credit Support (VM)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="IneligibleCreditSupport", builder=IneligibleCreditSupport.IneligibleCreditSupportBuilderImpl.class, version="6.23.0")
@RuneDataType(value="IneligibleCreditSupport", model="cdm", builder=IneligibleCreditSupport.IneligibleCreditSupportBuilderImpl.class, version="6.23.0")
public interface IneligibleCreditSupport extends RosettaModelObject {

	IneligibleCreditSupportMeta metaData = new IneligibleCreditSupportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Total Ineligibility Date has the meaning specified in Paragraph 11(g), unless otherwise specified here.
	 */
	String getTotalIneligibilityDate();
	/**
	 * Transfer Ineligibility Date has the meaning specified in Paragraph 11(g), unless otherwise specified here.
	 */
	String getTransferIneligibilityDate();
	/**
	 * The parties to which the provisions of the CSA will apply to, as the Secured Party.
	 *
	 * Body ISDA
	 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
	 * paragraph "13" * clause "(c)(iii)" * name "Legally Ineligible Credit Support (VM)"
	 *
	 * Provision 
	 *
	 */
	List<? extends ReferenceWithMetaParty> getSpecifiedParty();

	/*********************** Build Methods  ***********************/
	IneligibleCreditSupport build();
	
	IneligibleCreditSupport.IneligibleCreditSupportBuilder toBuilder();
	
	static IneligibleCreditSupport.IneligibleCreditSupportBuilder builder() {
		return new IneligibleCreditSupport.IneligibleCreditSupportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IneligibleCreditSupport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IneligibleCreditSupport> getType() {
		return IneligibleCreditSupport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("totalIneligibilityDate"), String.class, getTotalIneligibilityDate(), this);
		processor.processBasic(path.newSubPath("transferIneligibilityDate"), String.class, getTransferIneligibilityDate(), this);
		processRosetta(path.newSubPath("specifiedParty"), processor, ReferenceWithMetaParty.class, getSpecifiedParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface IneligibleCreditSupportBuilder extends IneligibleCreditSupport, RosettaModelObjectBuilder {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateSpecifiedParty(int index);
		@Override
		List<? extends ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> getSpecifiedParty();
		IneligibleCreditSupport.IneligibleCreditSupportBuilder setTotalIneligibilityDate(String totalIneligibilityDate);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder setTransferIneligibilityDate(String transferIneligibilityDate);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(ReferenceWithMetaParty specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(ReferenceWithMetaParty specifiedParty, int idx);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(Party specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(Party specifiedParty, int idx);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(List<? extends ReferenceWithMetaParty> specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder setSpecifiedParty(List<? extends ReferenceWithMetaParty> specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(List<? extends Party> specifiedParty);
		IneligibleCreditSupport.IneligibleCreditSupportBuilder setSpecifiedPartyValue(List<? extends Party> specifiedParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("totalIneligibilityDate"), String.class, getTotalIneligibilityDate(), this);
			processor.processBasic(path.newSubPath("transferIneligibilityDate"), String.class, getTransferIneligibilityDate(), this);
			processRosetta(path.newSubPath("specifiedParty"), processor, ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder.class, getSpecifiedParty());
		}
		

		IneligibleCreditSupport.IneligibleCreditSupportBuilder prune();
	}

	/*********************** Immutable Implementation of IneligibleCreditSupport  ***********************/
	class IneligibleCreditSupportImpl implements IneligibleCreditSupport {
		private final String totalIneligibilityDate;
		private final String transferIneligibilityDate;
		private final List<? extends ReferenceWithMetaParty> specifiedParty;
		
		protected IneligibleCreditSupportImpl(IneligibleCreditSupport.IneligibleCreditSupportBuilder builder) {
			this.totalIneligibilityDate = builder.getTotalIneligibilityDate();
			this.transferIneligibilityDate = builder.getTransferIneligibilityDate();
			this.specifiedParty = ofNullable(builder.getSpecifiedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("totalIneligibilityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalIneligibilityDate")
		public String getTotalIneligibilityDate() {
			return totalIneligibilityDate;
		}
		
		@Override
		@RosettaAttribute("transferIneligibilityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferIneligibilityDate")
		public String getTransferIneligibilityDate() {
			return transferIneligibilityDate;
		}
		
		@Override
		@RosettaAttribute("specifiedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedParty")
		public List<? extends ReferenceWithMetaParty> getSpecifiedParty() {
			return specifiedParty;
		}
		
		@Override
		public IneligibleCreditSupport build() {
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder toBuilder() {
			IneligibleCreditSupport.IneligibleCreditSupportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IneligibleCreditSupport.IneligibleCreditSupportBuilder builder) {
			ofNullable(getTotalIneligibilityDate()).ifPresent(builder::setTotalIneligibilityDate);
			ofNullable(getTransferIneligibilityDate()).ifPresent(builder::setTransferIneligibilityDate);
			ofNullable(getSpecifiedParty()).ifPresent(builder::setSpecifiedParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IneligibleCreditSupport _that = getType().cast(o);
		
			if (!Objects.equals(totalIneligibilityDate, _that.getTotalIneligibilityDate())) return false;
			if (!Objects.equals(transferIneligibilityDate, _that.getTransferIneligibilityDate())) return false;
			if (!ListEquals.listEquals(specifiedParty, _that.getSpecifiedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (totalIneligibilityDate != null ? totalIneligibilityDate.hashCode() : 0);
			_result = 31 * _result + (transferIneligibilityDate != null ? transferIneligibilityDate.hashCode() : 0);
			_result = 31 * _result + (specifiedParty != null ? specifiedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IneligibleCreditSupport {" +
				"totalIneligibilityDate=" + this.totalIneligibilityDate + ", " +
				"transferIneligibilityDate=" + this.transferIneligibilityDate + ", " +
				"specifiedParty=" + this.specifiedParty +
			'}';
		}
	}

	/*********************** Builder Implementation of IneligibleCreditSupport  ***********************/
	class IneligibleCreditSupportBuilderImpl implements IneligibleCreditSupport.IneligibleCreditSupportBuilder {
	
		protected String totalIneligibilityDate;
		protected String transferIneligibilityDate;
		protected List<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> specifiedParty = new ArrayList<>();
		
		@Override
		@RosettaAttribute("totalIneligibilityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalIneligibilityDate")
		public String getTotalIneligibilityDate() {
			return totalIneligibilityDate;
		}
		
		@Override
		@RosettaAttribute("transferIneligibilityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferIneligibilityDate")
		public String getTransferIneligibilityDate() {
			return transferIneligibilityDate;
		}
		
		@Override
		@RosettaAttribute("specifiedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedParty")
		public List<? extends ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder> getSpecifiedParty() {
			return specifiedParty;
		}
		
		@Override
		public ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder getOrCreateSpecifiedParty(int index) {
			if (specifiedParty==null) {
				this.specifiedParty = new ArrayList<>();
			}
			return getIndex(specifiedParty, index, () -> {
						ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder newSpecifiedParty = ReferenceWithMetaParty.builder();
						return newSpecifiedParty;
					});
		}
		
		@RosettaAttribute("totalIneligibilityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalIneligibilityDate")
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder setTotalIneligibilityDate(String _totalIneligibilityDate) {
			this.totalIneligibilityDate = _totalIneligibilityDate == null ? null : _totalIneligibilityDate;
			return this;
		}
		
		@RosettaAttribute("transferIneligibilityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transferIneligibilityDate")
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder setTransferIneligibilityDate(String _transferIneligibilityDate) {
			this.transferIneligibilityDate = _transferIneligibilityDate == null ? null : _transferIneligibilityDate;
			return this;
		}
		
		@RosettaAttribute("specifiedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("specifiedParty")
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(ReferenceWithMetaParty _specifiedParty) {
			if (_specifiedParty != null) {
				this.specifiedParty.add(_specifiedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(ReferenceWithMetaParty _specifiedParty, int idx) {
			getIndex(this.specifiedParty, idx, () -> _specifiedParty.toBuilder());
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(Party _specifiedParty) {
			this.getOrCreateSpecifiedParty(-1).setValue(_specifiedParty.toBuilder());
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(Party _specifiedParty, int idx) {
			this.getOrCreateSpecifiedParty(idx).setValue(_specifiedParty.toBuilder());
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedParty(List<? extends ReferenceWithMetaParty> specifiedPartys) {
			if (specifiedPartys != null) {
				for (final ReferenceWithMetaParty toAdd : specifiedPartys) {
					this.specifiedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("specifiedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("specifiedParty")
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder setSpecifiedParty(List<? extends ReferenceWithMetaParty> specifiedPartys) {
			if (specifiedPartys == null) {
				this.specifiedParty = new ArrayList<>();
			} else {
				this.specifiedParty = specifiedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder addSpecifiedPartyValue(List<? extends Party> specifiedPartys) {
			if (specifiedPartys != null) {
				for (final Party toAdd : specifiedPartys) {
					this.addSpecifiedPartyValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder setSpecifiedPartyValue(List<? extends Party> specifiedPartys) {
			this.specifiedParty.clear();
			if (specifiedPartys != null) {
				specifiedPartys.forEach(this::addSpecifiedPartyValue);
			}
			return this;
		}
		
		@Override
		public IneligibleCreditSupport build() {
			return new IneligibleCreditSupport.IneligibleCreditSupportImpl(this);
		}
		
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder prune() {
			specifiedParty = specifiedParty.stream().filter(b->b!=null).<ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTotalIneligibilityDate()!=null) return true;
			if (getTransferIneligibilityDate()!=null) return true;
			if (getSpecifiedParty()!=null && getSpecifiedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IneligibleCreditSupport.IneligibleCreditSupportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IneligibleCreditSupport.IneligibleCreditSupportBuilder o = (IneligibleCreditSupport.IneligibleCreditSupportBuilder) other;
			
			merger.mergeRosetta(getSpecifiedParty(), o.getSpecifiedParty(), this::getOrCreateSpecifiedParty);
			
			merger.mergeBasic(getTotalIneligibilityDate(), o.getTotalIneligibilityDate(), this::setTotalIneligibilityDate);
			merger.mergeBasic(getTransferIneligibilityDate(), o.getTransferIneligibilityDate(), this::setTransferIneligibilityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IneligibleCreditSupport _that = getType().cast(o);
		
			if (!Objects.equals(totalIneligibilityDate, _that.getTotalIneligibilityDate())) return false;
			if (!Objects.equals(transferIneligibilityDate, _that.getTransferIneligibilityDate())) return false;
			if (!ListEquals.listEquals(specifiedParty, _that.getSpecifiedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (totalIneligibilityDate != null ? totalIneligibilityDate.hashCode() : 0);
			_result = 31 * _result + (transferIneligibilityDate != null ? transferIneligibilityDate.hashCode() : 0);
			_result = 31 * _result + (specifiedParty != null ? specifiedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IneligibleCreditSupportBuilder {" +
				"totalIneligibilityDate=" + this.totalIneligibilityDate + ", " +
				"transferIneligibilityDate=" + this.transferIneligibilityDate + ", " +
				"specifiedParty=" + this.specifiedParty +
			'}';
		}
	}
}
