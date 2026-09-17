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
import fpml.consolidated.shared.meta.CashSettlementReferenceBanksMeta;
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
 * Provision A type defining the list of reference institutions polled for relevant rates or prices when determining the cash settlement amount for a product where cash settlement is applicable.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the list of reference institutions polled for relevant rates or prices when determining the cash settlement amount for a product where cash settlement is applicable.
 *
 */
@RosettaDataType(value="CashSettlementReferenceBanks", builder=CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CashSettlementReferenceBanks", model="fpml", builder=CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilderImpl.class, version="2.1.1")
public interface CashSettlementReferenceBanks extends RosettaModelObject {

	CashSettlementReferenceBanksMeta metaData = new CashSettlementReferenceBanksMeta();

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
	 * Provision An institution (party) identified by means of a coding scheme and an optional name.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An institution (party) identified by means of a coding scheme and an optional name.
	 *
	 */
	List<? extends ReferenceBank> getReferenceBank();

	/*********************** Build Methods  ***********************/
	CashSettlementReferenceBanks build();
	
	CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder toBuilder();
	
	static CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder builder() {
		return new CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashSettlementReferenceBanks> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CashSettlementReferenceBanks> getType() {
		return CashSettlementReferenceBanks.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("referenceBank"), processor, ReferenceBank.class, getReferenceBank());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashSettlementReferenceBanksBuilder extends CashSettlementReferenceBanks, RosettaModelObjectBuilder {
		ReferenceBank.ReferenceBankBuilder getOrCreateReferenceBank(int index);
		@Override
		List<? extends ReferenceBank.ReferenceBankBuilder> getReferenceBank();
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder setId(String id);
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(ReferenceBank referenceBank);
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(ReferenceBank referenceBank, int idx);
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(List<? extends ReferenceBank> referenceBank);
		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder setReferenceBank(List<? extends ReferenceBank> referenceBank);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("referenceBank"), processor, ReferenceBank.ReferenceBankBuilder.class, getReferenceBank());
		}
		

		CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder prune();
	}

	/*********************** Immutable Implementation of CashSettlementReferenceBanks  ***********************/
	class CashSettlementReferenceBanksImpl implements CashSettlementReferenceBanks {
		private final String id;
		private final List<? extends ReferenceBank> referenceBank;
		
		protected CashSettlementReferenceBanksImpl(CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder builder) {
			this.id = builder.getId();
			this.referenceBank = ofNullable(builder.getReferenceBank()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("referenceBank")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("referenceBank")
		public List<? extends ReferenceBank> getReferenceBank() {
			return referenceBank;
		}
		
		@Override
		public CashSettlementReferenceBanks build() {
			return this;
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder toBuilder() {
			CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getReferenceBank()).ifPresent(builder::setReferenceBank);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlementReferenceBanks _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(referenceBank, _that.getReferenceBank())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (referenceBank != null ? referenceBank.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementReferenceBanks {" +
				"id=" + this.id + ", " +
				"referenceBank=" + this.referenceBank +
			'}';
		}
	}

	/*********************** Builder Implementation of CashSettlementReferenceBanks  ***********************/
	class CashSettlementReferenceBanksBuilderImpl implements CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder {
	
		protected String id;
		protected List<ReferenceBank.ReferenceBankBuilder> referenceBank = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("referenceBank")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("referenceBank")
		public List<? extends ReferenceBank.ReferenceBankBuilder> getReferenceBank() {
			return referenceBank;
		}
		
		@Override
		public ReferenceBank.ReferenceBankBuilder getOrCreateReferenceBank(int index) {
			if (referenceBank==null) {
				this.referenceBank = new ArrayList<>();
			}
			return getIndex(referenceBank, index, () -> {
						ReferenceBank.ReferenceBankBuilder newReferenceBank = ReferenceBank.builder();
						return newReferenceBank;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("referenceBank")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("referenceBank")
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(ReferenceBank _referenceBank) {
			if (_referenceBank != null) {
				this.referenceBank.add(_referenceBank.toBuilder());
			}
			return this;
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(ReferenceBank _referenceBank, int idx) {
			getIndex(this.referenceBank, idx, () -> _referenceBank.toBuilder());
			return this;
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder addReferenceBank(List<? extends ReferenceBank> referenceBanks) {
			if (referenceBanks != null) {
				for (final ReferenceBank toAdd : referenceBanks) {
					this.referenceBank.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("referenceBank")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("referenceBank")
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder setReferenceBank(List<? extends ReferenceBank> referenceBanks) {
			if (referenceBanks == null) {
				this.referenceBank = new ArrayList<>();
			} else {
				this.referenceBank = referenceBanks.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CashSettlementReferenceBanks build() {
			return new CashSettlementReferenceBanks.CashSettlementReferenceBanksImpl(this);
		}
		
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder prune() {
			referenceBank = referenceBank.stream().filter(b->b!=null).<ReferenceBank.ReferenceBankBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getReferenceBank()!=null && getReferenceBank().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder o = (CashSettlementReferenceBanks.CashSettlementReferenceBanksBuilder) other;
			
			merger.mergeRosetta(getReferenceBank(), o.getReferenceBank(), this::getOrCreateReferenceBank);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashSettlementReferenceBanks _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!ListEquals.listEquals(referenceBank, _that.getReferenceBank())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (referenceBank != null ? referenceBank.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashSettlementReferenceBanksBuilder {" +
				"id=" + this.id + ", " +
				"referenceBank=" + this.referenceBank +
			'}';
		}
	}
}
