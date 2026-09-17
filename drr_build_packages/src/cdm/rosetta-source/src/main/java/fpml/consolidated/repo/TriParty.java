package fpml.consolidated.repo;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.repo.meta.TriPartyMeta;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The tri-party terms.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The tri-party terms.
 *
 */
@RosettaDataType(value="TriParty", builder=TriParty.TriPartyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="TriParty", model="fpml", builder=TriParty.TriPartyBuilderImpl.class, version="2.1.1")
public interface TriParty extends RosettaModelObject {

	TriPartyMeta metaData = new TriPartyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The reference to the tri-party agent.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The reference to the tri-party agent.
	 *
	 */
	PartyReference getTriPartyAgent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The collateral profile specified at the tri-party agent.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The collateral profile specified at the tri-party agent.
	 *
	 */
	CollateralProfile getCollateralProfile();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The collateral type, which is a restriction of the collateral deemed acceptable for the purpose of the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The collateral type, which is a restriction of the collateral deemed acceptable for the purpose of the transaction.
	 *
	 */
	CollateralType getCollateralType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies whether the transaction was settled using the Delivery-by-Value (DBV) mechanism.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies whether the transaction was settled using the Delivery-by-Value (DBV) mechanism.
	 *
	 */
	Boolean getDeliveryByValue();

	/*********************** Build Methods  ***********************/
	TriParty build();
	
	TriParty.TriPartyBuilder toBuilder();
	
	static TriParty.TriPartyBuilder builder() {
		return new TriParty.TriPartyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TriParty> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TriParty> getType() {
		return TriParty.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("triPartyAgent"), processor, PartyReference.class, getTriPartyAgent());
		processRosetta(path.newSubPath("collateralProfile"), processor, CollateralProfile.class, getCollateralProfile());
		processRosetta(path.newSubPath("collateralType"), processor, CollateralType.class, getCollateralType());
		processor.processBasic(path.newSubPath("deliveryByValue"), Boolean.class, getDeliveryByValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TriPartyBuilder extends TriParty, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateTriPartyAgent();
		@Override
		PartyReference.PartyReferenceBuilder getTriPartyAgent();
		CollateralProfile.CollateralProfileBuilder getOrCreateCollateralProfile();
		@Override
		CollateralProfile.CollateralProfileBuilder getCollateralProfile();
		CollateralType.CollateralTypeBuilder getOrCreateCollateralType();
		@Override
		CollateralType.CollateralTypeBuilder getCollateralType();
		TriParty.TriPartyBuilder setTriPartyAgent(PartyReference triPartyAgent);
		TriParty.TriPartyBuilder setCollateralProfile(CollateralProfile collateralProfile);
		TriParty.TriPartyBuilder setCollateralType(CollateralType collateralType);
		TriParty.TriPartyBuilder setDeliveryByValue(Boolean deliveryByValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("triPartyAgent"), processor, PartyReference.PartyReferenceBuilder.class, getTriPartyAgent());
			processRosetta(path.newSubPath("collateralProfile"), processor, CollateralProfile.CollateralProfileBuilder.class, getCollateralProfile());
			processRosetta(path.newSubPath("collateralType"), processor, CollateralType.CollateralTypeBuilder.class, getCollateralType());
			processor.processBasic(path.newSubPath("deliveryByValue"), Boolean.class, getDeliveryByValue(), this);
		}
		

		TriParty.TriPartyBuilder prune();
	}

	/*********************** Immutable Implementation of TriParty  ***********************/
	class TriPartyImpl implements TriParty {
		private final PartyReference triPartyAgent;
		private final CollateralProfile collateralProfile;
		private final CollateralType collateralType;
		private final Boolean deliveryByValue;
		
		protected TriPartyImpl(TriParty.TriPartyBuilder builder) {
			this.triPartyAgent = ofNullable(builder.getTriPartyAgent()).map(f->f.build()).orElse(null);
			this.collateralProfile = ofNullable(builder.getCollateralProfile()).map(f->f.build()).orElse(null);
			this.collateralType = ofNullable(builder.getCollateralType()).map(f->f.build()).orElse(null);
			this.deliveryByValue = builder.getDeliveryByValue();
		}
		
		@Override
		@RosettaAttribute("triPartyAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triPartyAgent")
		public PartyReference getTriPartyAgent() {
			return triPartyAgent;
		}
		
		@Override
		@RosettaAttribute("collateralProfile")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralProfile")
		public CollateralProfile getCollateralProfile() {
			return collateralProfile;
		}
		
		@Override
		@RosettaAttribute("collateralType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralType")
		public CollateralType getCollateralType() {
			return collateralType;
		}
		
		@Override
		@RosettaAttribute("deliveryByValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryByValue")
		public Boolean getDeliveryByValue() {
			return deliveryByValue;
		}
		
		@Override
		public TriParty build() {
			return this;
		}
		
		@Override
		public TriParty.TriPartyBuilder toBuilder() {
			TriParty.TriPartyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TriParty.TriPartyBuilder builder) {
			ofNullable(getTriPartyAgent()).ifPresent(builder::setTriPartyAgent);
			ofNullable(getCollateralProfile()).ifPresent(builder::setCollateralProfile);
			ofNullable(getCollateralType()).ifPresent(builder::setCollateralType);
			ofNullable(getDeliveryByValue()).ifPresent(builder::setDeliveryByValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriParty _that = getType().cast(o);
		
			if (!Objects.equals(triPartyAgent, _that.getTriPartyAgent())) return false;
			if (!Objects.equals(collateralProfile, _that.getCollateralProfile())) return false;
			if (!Objects.equals(collateralType, _that.getCollateralType())) return false;
			if (!Objects.equals(deliveryByValue, _that.getDeliveryByValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triPartyAgent != null ? triPartyAgent.hashCode() : 0);
			_result = 31 * _result + (collateralProfile != null ? collateralProfile.hashCode() : 0);
			_result = 31 * _result + (collateralType != null ? collateralType.hashCode() : 0);
			_result = 31 * _result + (deliveryByValue != null ? deliveryByValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriParty {" +
				"triPartyAgent=" + this.triPartyAgent + ", " +
				"collateralProfile=" + this.collateralProfile + ", " +
				"collateralType=" + this.collateralType + ", " +
				"deliveryByValue=" + this.deliveryByValue +
			'}';
		}
	}

	/*********************** Builder Implementation of TriParty  ***********************/
	class TriPartyBuilderImpl implements TriParty.TriPartyBuilder {
	
		protected PartyReference.PartyReferenceBuilder triPartyAgent;
		protected CollateralProfile.CollateralProfileBuilder collateralProfile;
		protected CollateralType.CollateralTypeBuilder collateralType;
		protected Boolean deliveryByValue;
		
		@Override
		@RosettaAttribute("triPartyAgent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("triPartyAgent")
		public PartyReference.PartyReferenceBuilder getTriPartyAgent() {
			return triPartyAgent;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateTriPartyAgent() {
			PartyReference.PartyReferenceBuilder result;
			if (triPartyAgent!=null) {
				result = triPartyAgent;
			}
			else {
				result = triPartyAgent = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralProfile")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralProfile")
		public CollateralProfile.CollateralProfileBuilder getCollateralProfile() {
			return collateralProfile;
		}
		
		@Override
		public CollateralProfile.CollateralProfileBuilder getOrCreateCollateralProfile() {
			CollateralProfile.CollateralProfileBuilder result;
			if (collateralProfile!=null) {
				result = collateralProfile;
			}
			else {
				result = collateralProfile = CollateralProfile.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralType")
		public CollateralType.CollateralTypeBuilder getCollateralType() {
			return collateralType;
		}
		
		@Override
		public CollateralType.CollateralTypeBuilder getOrCreateCollateralType() {
			CollateralType.CollateralTypeBuilder result;
			if (collateralType!=null) {
				result = collateralType;
			}
			else {
				result = collateralType = CollateralType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryByValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryByValue")
		public Boolean getDeliveryByValue() {
			return deliveryByValue;
		}
		
		@RosettaAttribute("triPartyAgent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("triPartyAgent")
		@Override
		public TriParty.TriPartyBuilder setTriPartyAgent(PartyReference _triPartyAgent) {
			this.triPartyAgent = _triPartyAgent == null ? null : _triPartyAgent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralProfile")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralProfile")
		@Override
		public TriParty.TriPartyBuilder setCollateralProfile(CollateralProfile _collateralProfile) {
			this.collateralProfile = _collateralProfile == null ? null : _collateralProfile.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralType")
		@Override
		public TriParty.TriPartyBuilder setCollateralType(CollateralType _collateralType) {
			this.collateralType = _collateralType == null ? null : _collateralType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryByValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryByValue")
		@Override
		public TriParty.TriPartyBuilder setDeliveryByValue(Boolean _deliveryByValue) {
			this.deliveryByValue = _deliveryByValue == null ? null : _deliveryByValue;
			return this;
		}
		
		@Override
		public TriParty build() {
			return new TriParty.TriPartyImpl(this);
		}
		
		@Override
		public TriParty.TriPartyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriParty.TriPartyBuilder prune() {
			if (triPartyAgent!=null && !triPartyAgent.prune().hasData()) triPartyAgent = null;
			if (collateralProfile!=null && !collateralProfile.prune().hasData()) collateralProfile = null;
			if (collateralType!=null && !collateralType.prune().hasData()) collateralType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTriPartyAgent()!=null && getTriPartyAgent().hasData()) return true;
			if (getCollateralProfile()!=null && getCollateralProfile().hasData()) return true;
			if (getCollateralType()!=null && getCollateralType().hasData()) return true;
			if (getDeliveryByValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TriParty.TriPartyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TriParty.TriPartyBuilder o = (TriParty.TriPartyBuilder) other;
			
			merger.mergeRosetta(getTriPartyAgent(), o.getTriPartyAgent(), this::setTriPartyAgent);
			merger.mergeRosetta(getCollateralProfile(), o.getCollateralProfile(), this::setCollateralProfile);
			merger.mergeRosetta(getCollateralType(), o.getCollateralType(), this::setCollateralType);
			
			merger.mergeBasic(getDeliveryByValue(), o.getDeliveryByValue(), this::setDeliveryByValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TriParty _that = getType().cast(o);
		
			if (!Objects.equals(triPartyAgent, _that.getTriPartyAgent())) return false;
			if (!Objects.equals(collateralProfile, _that.getCollateralProfile())) return false;
			if (!Objects.equals(collateralType, _that.getCollateralType())) return false;
			if (!Objects.equals(deliveryByValue, _that.getDeliveryByValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (triPartyAgent != null ? triPartyAgent.hashCode() : 0);
			_result = 31 * _result + (collateralProfile != null ? collateralProfile.hashCode() : 0);
			_result = 31 * _result + (collateralType != null ? collateralType.hashCode() : 0);
			_result = 31 * _result + (deliveryByValue != null ? deliveryByValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriPartyBuilder {" +
				"triPartyAgent=" + this.triPartyAgent + ", " +
				"collateralProfile=" + this.collateralProfile + ", " +
				"collateralType=" + this.collateralType + ", " +
				"deliveryByValue=" + this.deliveryByValue +
			'}';
		}
	}
}
