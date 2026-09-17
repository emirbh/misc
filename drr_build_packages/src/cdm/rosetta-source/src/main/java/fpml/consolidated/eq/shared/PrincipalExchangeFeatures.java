package fpml.consolidated.eq.shared;

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
import fpml.consolidated.eq.shared.meta.PrincipalExchangeFeaturesMeta;
import fpml.consolidated.shared.PrincipalExchanges;
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
 * Provision A type describing the principal exchange features of the return swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type describing the principal exchange features of the return swap.
 *
 */
@RosettaDataType(value="PrincipalExchangeFeatures", builder=PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PrincipalExchangeFeatures", model="fpml", builder=PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilderImpl.class, version="2.1.1")
public interface PrincipalExchangeFeatures extends RosettaModelObject {

	PrincipalExchangeFeaturesMeta metaData = new PrincipalExchangeFeaturesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The true/false flags indicating whether initial, intermediate or final exchanges of principal should occur.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The true/false flags indicating whether initial, intermediate or final exchanges of principal should occur.
	 *
	 */
	PrincipalExchanges getPrincipalExchanges();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies each of the characteristics of the principal exchange cashflows, in terms of paying/receiving counterparties, amounts and dates.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies each of the characteristics of the principal exchange cashflows, in terms of paying/receiving counterparties, amounts and dates.
	 *
	 */
	List<? extends PrincipalExchangeDescriptions> getPrincipalExchangeDescriptions();

	/*********************** Build Methods  ***********************/
	PrincipalExchangeFeatures build();
	
	PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder toBuilder();
	
	static PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder builder() {
		return new PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalExchangeFeatures> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PrincipalExchangeFeatures> getType() {
		return PrincipalExchangeFeatures.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("principalExchanges"), processor, PrincipalExchanges.class, getPrincipalExchanges());
		processRosetta(path.newSubPath("principalExchangeDescriptions"), processor, PrincipalExchangeDescriptions.class, getPrincipalExchangeDescriptions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalExchangeFeaturesBuilder extends PrincipalExchangeFeatures, RosettaModelObjectBuilder {
		PrincipalExchanges.PrincipalExchangesBuilder getOrCreatePrincipalExchanges();
		@Override
		PrincipalExchanges.PrincipalExchangesBuilder getPrincipalExchanges();
		PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder getOrCreatePrincipalExchangeDescriptions(int index);
		@Override
		List<? extends PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder> getPrincipalExchangeDescriptions();
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder setPrincipalExchanges(PrincipalExchanges principalExchanges);
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(PrincipalExchangeDescriptions principalExchangeDescriptions);
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(PrincipalExchangeDescriptions principalExchangeDescriptions, int idx);
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(List<? extends PrincipalExchangeDescriptions> principalExchangeDescriptions);
		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder setPrincipalExchangeDescriptions(List<? extends PrincipalExchangeDescriptions> principalExchangeDescriptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("principalExchanges"), processor, PrincipalExchanges.PrincipalExchangesBuilder.class, getPrincipalExchanges());
			processRosetta(path.newSubPath("principalExchangeDescriptions"), processor, PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder.class, getPrincipalExchangeDescriptions());
		}
		

		PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalExchangeFeatures  ***********************/
	class PrincipalExchangeFeaturesImpl implements PrincipalExchangeFeatures {
		private final PrincipalExchanges principalExchanges;
		private final List<? extends PrincipalExchangeDescriptions> principalExchangeDescriptions;
		
		protected PrincipalExchangeFeaturesImpl(PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder builder) {
			this.principalExchanges = ofNullable(builder.getPrincipalExchanges()).map(f->f.build()).orElse(null);
			this.principalExchangeDescriptions = ofNullable(builder.getPrincipalExchangeDescriptions()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("principalExchanges")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchanges")
		public PrincipalExchanges getPrincipalExchanges() {
			return principalExchanges;
		}
		
		@Override
		@RosettaAttribute("principalExchangeDescriptions")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("principalExchangeDescriptions")
		public List<? extends PrincipalExchangeDescriptions> getPrincipalExchangeDescriptions() {
			return principalExchangeDescriptions;
		}
		
		@Override
		public PrincipalExchangeFeatures build() {
			return this;
		}
		
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder toBuilder() {
			PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder builder) {
			ofNullable(getPrincipalExchanges()).ifPresent(builder::setPrincipalExchanges);
			ofNullable(getPrincipalExchangeDescriptions()).ifPresent(builder::setPrincipalExchangeDescriptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeFeatures _that = getType().cast(o);
		
			if (!Objects.equals(principalExchanges, _that.getPrincipalExchanges())) return false;
			if (!ListEquals.listEquals(principalExchangeDescriptions, _that.getPrincipalExchangeDescriptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (principalExchanges != null ? principalExchanges.hashCode() : 0);
			_result = 31 * _result + (principalExchangeDescriptions != null ? principalExchangeDescriptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeFeatures {" +
				"principalExchanges=" + this.principalExchanges + ", " +
				"principalExchangeDescriptions=" + this.principalExchangeDescriptions +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalExchangeFeatures  ***********************/
	class PrincipalExchangeFeaturesBuilderImpl implements PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder {
	
		protected PrincipalExchanges.PrincipalExchangesBuilder principalExchanges;
		protected List<PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder> principalExchangeDescriptions = new ArrayList<>();
		
		@Override
		@RosettaAttribute("principalExchanges")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("principalExchanges")
		public PrincipalExchanges.PrincipalExchangesBuilder getPrincipalExchanges() {
			return principalExchanges;
		}
		
		@Override
		public PrincipalExchanges.PrincipalExchangesBuilder getOrCreatePrincipalExchanges() {
			PrincipalExchanges.PrincipalExchangesBuilder result;
			if (principalExchanges!=null) {
				result = principalExchanges;
			}
			else {
				result = principalExchanges = PrincipalExchanges.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("principalExchangeDescriptions")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("principalExchangeDescriptions")
		public List<? extends PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder> getPrincipalExchangeDescriptions() {
			return principalExchangeDescriptions;
		}
		
		@Override
		public PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder getOrCreatePrincipalExchangeDescriptions(int index) {
			if (principalExchangeDescriptions==null) {
				this.principalExchangeDescriptions = new ArrayList<>();
			}
			return getIndex(principalExchangeDescriptions, index, () -> {
						PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder newPrincipalExchangeDescriptions = PrincipalExchangeDescriptions.builder();
						return newPrincipalExchangeDescriptions;
					});
		}
		
		@RosettaAttribute("principalExchanges")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("principalExchanges")
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder setPrincipalExchanges(PrincipalExchanges _principalExchanges) {
			this.principalExchanges = _principalExchanges == null ? null : _principalExchanges.toBuilder();
			return this;
		}
		
		@RosettaAttribute("principalExchangeDescriptions")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("principalExchangeDescriptions")
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(PrincipalExchangeDescriptions _principalExchangeDescriptions) {
			if (_principalExchangeDescriptions != null) {
				this.principalExchangeDescriptions.add(_principalExchangeDescriptions.toBuilder());
			}
			return this;
		}
		
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(PrincipalExchangeDescriptions _principalExchangeDescriptions, int idx) {
			getIndex(this.principalExchangeDescriptions, idx, () -> _principalExchangeDescriptions.toBuilder());
			return this;
		}
		
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder addPrincipalExchangeDescriptions(List<? extends PrincipalExchangeDescriptions> principalExchangeDescriptionss) {
			if (principalExchangeDescriptionss != null) {
				for (final PrincipalExchangeDescriptions toAdd : principalExchangeDescriptionss) {
					this.principalExchangeDescriptions.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("principalExchangeDescriptions")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("principalExchangeDescriptions")
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder setPrincipalExchangeDescriptions(List<? extends PrincipalExchangeDescriptions> principalExchangeDescriptionss) {
			if (principalExchangeDescriptionss == null) {
				this.principalExchangeDescriptions = new ArrayList<>();
			} else {
				this.principalExchangeDescriptions = principalExchangeDescriptionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PrincipalExchangeFeatures build() {
			return new PrincipalExchangeFeatures.PrincipalExchangeFeaturesImpl(this);
		}
		
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder prune() {
			if (principalExchanges!=null && !principalExchanges.prune().hasData()) principalExchanges = null;
			principalExchangeDescriptions = principalExchangeDescriptions.stream().filter(b->b!=null).<PrincipalExchangeDescriptions.PrincipalExchangeDescriptionsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrincipalExchanges()!=null && getPrincipalExchanges().hasData()) return true;
			if (getPrincipalExchangeDescriptions()!=null && getPrincipalExchangeDescriptions().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder o = (PrincipalExchangeFeatures.PrincipalExchangeFeaturesBuilder) other;
			
			merger.mergeRosetta(getPrincipalExchanges(), o.getPrincipalExchanges(), this::setPrincipalExchanges);
			merger.mergeRosetta(getPrincipalExchangeDescriptions(), o.getPrincipalExchangeDescriptions(), this::getOrCreatePrincipalExchangeDescriptions);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchangeFeatures _that = getType().cast(o);
		
			if (!Objects.equals(principalExchanges, _that.getPrincipalExchanges())) return false;
			if (!ListEquals.listEquals(principalExchangeDescriptions, _that.getPrincipalExchangeDescriptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (principalExchanges != null ? principalExchanges.hashCode() : 0);
			_result = 31 * _result + (principalExchangeDescriptions != null ? principalExchangeDescriptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeFeaturesBuilder {" +
				"principalExchanges=" + this.principalExchanges + ", " +
				"principalExchangeDescriptions=" + this.principalExchangeDescriptions +
			'}';
		}
	}
}
