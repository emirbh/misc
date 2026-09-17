package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.SwapMeta;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.Product;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
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
 * Provision A type defining swap streams and additional payments between the principal parties involved in the swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining swap streams and additional payments between the principal parties involved in the swap.
 *
 */
@RosettaDataType(value="Swap", builder=Swap.SwapBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Swap", model="fpml", builder=Swap.SwapBuilderImpl.class, version="2.1.1")
public interface Swap extends Product {

	SwapMeta metaData = new SwapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The swap streams.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The swap streams.
	 *
	 */
	List<? extends InterestRateStream> getSwapStream();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Parameters specifying provisions relating to the optional and mandatory early terminarion of a swap transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Parameters specifying provisions relating to the optional and mandatory early terminarion of a swap transaction.
	 *
	 */
	EarlyTerminationProvision getEarlyTerminationProvision();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A provision that allows the specification of an embedded option within a swap giving the buyer of the option the right to terminate the swap, in whole or in part, on the early termination date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A provision that allows the specification of an embedded option within a swap giving the buyer of the option the right to terminate the swap, in whole or in part, on the early termination date.
	 *
	 */
	CancelableProvision getCancelableProvision();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A provision that allows the specification of an embedded option with a swap giving the buyer of the option the right to extend the swap, in whole or in part, to the extended termination date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A provision that allows the specification of an embedded option with a swap giving the buyer of the option the right to extend the swap, in whole or in part, to the extended termination date.
	 *
	 */
	ExtendibleProvision getExtendibleProvision();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Additional payments between the principal parties.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Additional payments between the principal parties.
	 *
	 */
	List<? extends Payment> getAdditionalPayment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Contains any additional terms to the swap contract.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Contains any additional terms to the swap contract.
	 *
	 */
	SwapAdditionalTerms getAdditionalTerms();

	/*********************** Build Methods  ***********************/
	Swap build();
	
	Swap.SwapBuilder toBuilder();
	
	static Swap.SwapBuilder builder() {
		return new Swap.SwapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Swap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Swap> getType() {
		return Swap.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
		processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.class, getEmbeddedOptionType());
		processRosetta(path.newSubPath("assetClass"), processor, AssetClass.class, getAssetClass());
		processRosetta(path.newSubPath("swapStream"), processor, InterestRateStream.class, getSwapStream());
		processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.class, getEarlyTerminationProvision());
		processRosetta(path.newSubPath("cancelableProvision"), processor, CancelableProvision.class, getCancelableProvision());
		processRosetta(path.newSubPath("extendibleProvision"), processor, ExtendibleProvision.class, getExtendibleProvision());
		processRosetta(path.newSubPath("additionalPayment"), processor, Payment.class, getAdditionalPayment());
		processRosetta(path.newSubPath("additionalTerms"), processor, SwapAdditionalTerms.class, getAdditionalTerms());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SwapBuilder extends Swap, Product.ProductBuilder {
		InterestRateStream.InterestRateStreamBuilder getOrCreateSwapStream(int index);
		@Override
		List<? extends InterestRateStream.InterestRateStreamBuilder> getSwapStream();
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision();
		@Override
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision();
		CancelableProvision.CancelableProvisionBuilder getOrCreateCancelableProvision();
		@Override
		CancelableProvision.CancelableProvisionBuilder getCancelableProvision();
		ExtendibleProvision.ExtendibleProvisionBuilder getOrCreateExtendibleProvision();
		@Override
		ExtendibleProvision.ExtendibleProvisionBuilder getExtendibleProvision();
		Payment.PaymentBuilder getOrCreateAdditionalPayment(int index);
		@Override
		List<? extends Payment.PaymentBuilder> getAdditionalPayment();
		SwapAdditionalTerms.SwapAdditionalTermsBuilder getOrCreateAdditionalTerms();
		@Override
		SwapAdditionalTerms.SwapAdditionalTermsBuilder getAdditionalTerms();
		@Override
		Swap.SwapBuilder setId(String id);
		@Override
		Swap.SwapBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		Swap.SwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		Swap.SwapBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		Swap.SwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		Swap.SwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		Swap.SwapBuilder addProductType(ProductType productType);
		@Override
		Swap.SwapBuilder addProductType(ProductType productType, int idx);
		@Override
		Swap.SwapBuilder addProductType(List<? extends ProductType> productType);
		@Override
		Swap.SwapBuilder setProductType(List<? extends ProductType> productType);
		@Override
		Swap.SwapBuilder addProductId(ProductId productId);
		@Override
		Swap.SwapBuilder addProductId(ProductId productId, int idx);
		@Override
		Swap.SwapBuilder addProductId(List<? extends ProductId> productId);
		@Override
		Swap.SwapBuilder setProductId(List<? extends ProductId> productId);
		@Override
		Swap.SwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		Swap.SwapBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		Swap.SwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		Swap.SwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		Swap.SwapBuilder addAssetClass(AssetClass assetClass);
		@Override
		Swap.SwapBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		Swap.SwapBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		Swap.SwapBuilder setAssetClass(List<? extends AssetClass> assetClass);
		Swap.SwapBuilder addSwapStream(InterestRateStream swapStream);
		Swap.SwapBuilder addSwapStream(InterestRateStream swapStream, int idx);
		Swap.SwapBuilder addSwapStream(List<? extends InterestRateStream> swapStream);
		Swap.SwapBuilder setSwapStream(List<? extends InterestRateStream> swapStream);
		Swap.SwapBuilder setEarlyTerminationProvision(EarlyTerminationProvision earlyTerminationProvision);
		Swap.SwapBuilder setCancelableProvision(CancelableProvision cancelableProvision);
		Swap.SwapBuilder setExtendibleProvision(ExtendibleProvision extendibleProvision);
		Swap.SwapBuilder addAdditionalPayment(Payment additionalPayment);
		Swap.SwapBuilder addAdditionalPayment(Payment additionalPayment, int idx);
		Swap.SwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayment);
		Swap.SwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayment);
		Swap.SwapBuilder setAdditionalTerms(SwapAdditionalTerms additionalTerms);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("swapStream"), processor, InterestRateStream.InterestRateStreamBuilder.class, getSwapStream());
			processRosetta(path.newSubPath("earlyTerminationProvision"), processor, EarlyTerminationProvision.EarlyTerminationProvisionBuilder.class, getEarlyTerminationProvision());
			processRosetta(path.newSubPath("cancelableProvision"), processor, CancelableProvision.CancelableProvisionBuilder.class, getCancelableProvision());
			processRosetta(path.newSubPath("extendibleProvision"), processor, ExtendibleProvision.ExtendibleProvisionBuilder.class, getExtendibleProvision());
			processRosetta(path.newSubPath("additionalPayment"), processor, Payment.PaymentBuilder.class, getAdditionalPayment());
			processRosetta(path.newSubPath("additionalTerms"), processor, SwapAdditionalTerms.SwapAdditionalTermsBuilder.class, getAdditionalTerms());
		}
		

		Swap.SwapBuilder prune();
	}

	/*********************** Immutable Implementation of Swap  ***********************/
	class SwapImpl extends Product.ProductImpl implements Swap {
		private final List<? extends InterestRateStream> swapStream;
		private final EarlyTerminationProvision earlyTerminationProvision;
		private final CancelableProvision cancelableProvision;
		private final ExtendibleProvision extendibleProvision;
		private final List<? extends Payment> additionalPayment;
		private final SwapAdditionalTerms additionalTerms;
		
		protected SwapImpl(Swap.SwapBuilder builder) {
			super(builder);
			this.swapStream = ofNullable(builder.getSwapStream()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.earlyTerminationProvision = ofNullable(builder.getEarlyTerminationProvision()).map(f->f.build()).orElse(null);
			this.cancelableProvision = ofNullable(builder.getCancelableProvision()).map(f->f.build()).orElse(null);
			this.extendibleProvision = ofNullable(builder.getExtendibleProvision()).map(f->f.build()).orElse(null);
			this.additionalPayment = ofNullable(builder.getAdditionalPayment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalTerms = ofNullable(builder.getAdditionalTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("swapStream")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("swapStream")
		public List<? extends InterestRateStream> getSwapStream() {
			return swapStream;
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationProvision")
		public EarlyTerminationProvision getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		@RosettaAttribute("cancelableProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cancelableProvision")
		public CancelableProvision getCancelableProvision() {
			return cancelableProvision;
		}
		
		@Override
		@RosettaAttribute("extendibleProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extendibleProvision")
		public ExtendibleProvision getExtendibleProvision() {
			return extendibleProvision;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends Payment> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		@RosettaAttribute("additionalTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalTerms")
		public SwapAdditionalTerms getAdditionalTerms() {
			return additionalTerms;
		}
		
		@Override
		public Swap build() {
			return this;
		}
		
		@Override
		public Swap.SwapBuilder toBuilder() {
			Swap.SwapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Swap.SwapBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSwapStream()).ifPresent(builder::setSwapStream);
			ofNullable(getEarlyTerminationProvision()).ifPresent(builder::setEarlyTerminationProvision);
			ofNullable(getCancelableProvision()).ifPresent(builder::setCancelableProvision);
			ofNullable(getExtendibleProvision()).ifPresent(builder::setExtendibleProvision);
			ofNullable(getAdditionalPayment()).ifPresent(builder::setAdditionalPayment);
			ofNullable(getAdditionalTerms()).ifPresent(builder::setAdditionalTerms);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Swap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(swapStream, _that.getSwapStream())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			if (!Objects.equals(cancelableProvision, _that.getCancelableProvision())) return false;
			if (!Objects.equals(extendibleProvision, _that.getExtendibleProvision())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(additionalTerms, _that.getAdditionalTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (swapStream != null ? swapStream.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			_result = 31 * _result + (cancelableProvision != null ? cancelableProvision.hashCode() : 0);
			_result = 31 * _result + (extendibleProvision != null ? extendibleProvision.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (additionalTerms != null ? additionalTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Swap {" +
				"swapStream=" + this.swapStream + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision + ", " +
				"cancelableProvision=" + this.cancelableProvision + ", " +
				"extendibleProvision=" + this.extendibleProvision + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"additionalTerms=" + this.additionalTerms +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Swap  ***********************/
	class SwapBuilderImpl extends Product.ProductBuilderImpl implements Swap.SwapBuilder {
	
		protected List<InterestRateStream.InterestRateStreamBuilder> swapStream = new ArrayList<>();
		protected EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvision;
		protected CancelableProvision.CancelableProvisionBuilder cancelableProvision;
		protected ExtendibleProvision.ExtendibleProvisionBuilder extendibleProvision;
		protected List<Payment.PaymentBuilder> additionalPayment = new ArrayList<>();
		protected SwapAdditionalTerms.SwapAdditionalTermsBuilder additionalTerms;
		
		@Override
		@RosettaAttribute("swapStream")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("swapStream")
		public List<? extends InterestRateStream.InterestRateStreamBuilder> getSwapStream() {
			return swapStream;
		}
		
		@Override
		public InterestRateStream.InterestRateStreamBuilder getOrCreateSwapStream(int index) {
			if (swapStream==null) {
				this.swapStream = new ArrayList<>();
			}
			return getIndex(swapStream, index, () -> {
						InterestRateStream.InterestRateStreamBuilder newSwapStream = InterestRateStream.builder();
						return newSwapStream;
					});
		}
		
		@Override
		@RosettaAttribute("earlyTerminationProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("earlyTerminationProvision")
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder getEarlyTerminationProvision() {
			return earlyTerminationProvision;
		}
		
		@Override
		public EarlyTerminationProvision.EarlyTerminationProvisionBuilder getOrCreateEarlyTerminationProvision() {
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder result;
			if (earlyTerminationProvision!=null) {
				result = earlyTerminationProvision;
			}
			else {
				result = earlyTerminationProvision = EarlyTerminationProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cancelableProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cancelableProvision")
		public CancelableProvision.CancelableProvisionBuilder getCancelableProvision() {
			return cancelableProvision;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder getOrCreateCancelableProvision() {
			CancelableProvision.CancelableProvisionBuilder result;
			if (cancelableProvision!=null) {
				result = cancelableProvision;
			}
			else {
				result = cancelableProvision = CancelableProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("extendibleProvision")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extendibleProvision")
		public ExtendibleProvision.ExtendibleProvisionBuilder getExtendibleProvision() {
			return extendibleProvision;
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder getOrCreateExtendibleProvision() {
			ExtendibleProvision.ExtendibleProvisionBuilder result;
			if (extendibleProvision!=null) {
				result = extendibleProvision;
			}
			else {
				result = extendibleProvision = ExtendibleProvision.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		public List<? extends Payment.PaymentBuilder> getAdditionalPayment() {
			return additionalPayment;
		}
		
		@Override
		public Payment.PaymentBuilder getOrCreateAdditionalPayment(int index) {
			if (additionalPayment==null) {
				this.additionalPayment = new ArrayList<>();
			}
			return getIndex(additionalPayment, index, () -> {
						Payment.PaymentBuilder newAdditionalPayment = Payment.builder();
						return newAdditionalPayment;
					});
		}
		
		@Override
		@RosettaAttribute("additionalTerms")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalTerms")
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder getAdditionalTerms() {
			return additionalTerms;
		}
		
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder getOrCreateAdditionalTerms() {
			SwapAdditionalTerms.SwapAdditionalTermsBuilder result;
			if (additionalTerms!=null) {
				result = additionalTerms;
			}
			else {
				result = additionalTerms = SwapAdditionalTerms.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Swap.SwapBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public Swap.SwapBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public Swap.SwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss != null) {
				for (final AssetClass toAdd : secondaryAssetClasss) {
					this.secondaryAssetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public Swap.SwapBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss == null) {
				this.secondaryAssetClass = new ArrayList<>();
			} else {
				this.secondaryAssetClass = secondaryAssetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public Swap.SwapBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addProductType(List<? extends ProductType> productTypes) {
			if (productTypes != null) {
				for (final ProductType toAdd : productTypes) {
					this.productType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public Swap.SwapBuilder setProductType(List<? extends ProductType> productTypes) {
			if (productTypes == null) {
				this.productType = new ArrayList<>();
			} else {
				this.productType = productTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public Swap.SwapBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addProductId(List<? extends ProductId> productIds) {
			if (productIds != null) {
				for (final ProductId toAdd : productIds) {
					this.productId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public Swap.SwapBuilder setProductId(List<? extends ProductId> productIds) {
			if (productIds == null) {
				this.productId = new ArrayList<>();
			} else {
				this.productId = productIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public Swap.SwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes != null) {
				for (final EmbeddedOptionType toAdd : embeddedOptionTypes) {
					this.embeddedOptionType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public Swap.SwapBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes == null) {
				this.embeddedOptionType = new ArrayList<>();
			} else {
				this.embeddedOptionType = embeddedOptionTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public Swap.SwapBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss != null) {
				for (final AssetClass toAdd : assetClasss) {
					this.assetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public Swap.SwapBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("swapStream")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("swapStream")
		@Override
		public Swap.SwapBuilder addSwapStream(InterestRateStream _swapStream) {
			if (_swapStream != null) {
				this.swapStream.add(_swapStream.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addSwapStream(InterestRateStream _swapStream, int idx) {
			getIndex(this.swapStream, idx, () -> _swapStream.toBuilder());
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addSwapStream(List<? extends InterestRateStream> swapStreams) {
			if (swapStreams != null) {
				for (final InterestRateStream toAdd : swapStreams) {
					this.swapStream.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("swapStream")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("swapStream")
		@Override
		public Swap.SwapBuilder setSwapStream(List<? extends InterestRateStream> swapStreams) {
			if (swapStreams == null) {
				this.swapStream = new ArrayList<>();
			} else {
				this.swapStream = swapStreams.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("earlyTerminationProvision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("earlyTerminationProvision")
		@Override
		public Swap.SwapBuilder setEarlyTerminationProvision(EarlyTerminationProvision _earlyTerminationProvision) {
			this.earlyTerminationProvision = _earlyTerminationProvision == null ? null : _earlyTerminationProvision.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cancelableProvision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cancelableProvision")
		@Override
		public Swap.SwapBuilder setCancelableProvision(CancelableProvision _cancelableProvision) {
			this.cancelableProvision = _cancelableProvision == null ? null : _cancelableProvision.toBuilder();
			return this;
		}
		
		@RosettaAttribute("extendibleProvision")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extendibleProvision")
		@Override
		public Swap.SwapBuilder setExtendibleProvision(ExtendibleProvision _extendibleProvision) {
			this.extendibleProvision = _extendibleProvision == null ? null : _extendibleProvision.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public Swap.SwapBuilder addAdditionalPayment(Payment _additionalPayment) {
			if (_additionalPayment != null) {
				this.additionalPayment.add(_additionalPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addAdditionalPayment(Payment _additionalPayment, int idx) {
			getIndex(this.additionalPayment, idx, () -> _additionalPayment.toBuilder());
			return this;
		}
		
		@Override
		public Swap.SwapBuilder addAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments != null) {
				for (final Payment toAdd : additionalPayments) {
					this.additionalPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalPayment")
		@Override
		public Swap.SwapBuilder setAdditionalPayment(List<? extends Payment> additionalPayments) {
			if (additionalPayments == null) {
				this.additionalPayment = new ArrayList<>();
			} else {
				this.additionalPayment = additionalPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalTerms")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalTerms")
		@Override
		public Swap.SwapBuilder setAdditionalTerms(SwapAdditionalTerms _additionalTerms) {
			this.additionalTerms = _additionalTerms == null ? null : _additionalTerms.toBuilder();
			return this;
		}
		
		@Override
		public Swap build() {
			return new Swap.SwapImpl(this);
		}
		
		@Override
		public Swap.SwapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Swap.SwapBuilder prune() {
			super.prune();
			swapStream = swapStream.stream().filter(b->b!=null).<InterestRateStream.InterestRateStreamBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (earlyTerminationProvision!=null && !earlyTerminationProvision.prune().hasData()) earlyTerminationProvision = null;
			if (cancelableProvision!=null && !cancelableProvision.prune().hasData()) cancelableProvision = null;
			if (extendibleProvision!=null && !extendibleProvision.prune().hasData()) extendibleProvision = null;
			additionalPayment = additionalPayment.stream().filter(b->b!=null).<Payment.PaymentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (additionalTerms!=null && !additionalTerms.prune().hasData()) additionalTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSwapStream()!=null && getSwapStream().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEarlyTerminationProvision()!=null && getEarlyTerminationProvision().hasData()) return true;
			if (getCancelableProvision()!=null && getCancelableProvision().hasData()) return true;
			if (getExtendibleProvision()!=null && getExtendibleProvision().hasData()) return true;
			if (getAdditionalPayment()!=null && getAdditionalPayment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalTerms()!=null && getAdditionalTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Swap.SwapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Swap.SwapBuilder o = (Swap.SwapBuilder) other;
			
			merger.mergeRosetta(getSwapStream(), o.getSwapStream(), this::getOrCreateSwapStream);
			merger.mergeRosetta(getEarlyTerminationProvision(), o.getEarlyTerminationProvision(), this::setEarlyTerminationProvision);
			merger.mergeRosetta(getCancelableProvision(), o.getCancelableProvision(), this::setCancelableProvision);
			merger.mergeRosetta(getExtendibleProvision(), o.getExtendibleProvision(), this::setExtendibleProvision);
			merger.mergeRosetta(getAdditionalPayment(), o.getAdditionalPayment(), this::getOrCreateAdditionalPayment);
			merger.mergeRosetta(getAdditionalTerms(), o.getAdditionalTerms(), this::setAdditionalTerms);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Swap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(swapStream, _that.getSwapStream())) return false;
			if (!Objects.equals(earlyTerminationProvision, _that.getEarlyTerminationProvision())) return false;
			if (!Objects.equals(cancelableProvision, _that.getCancelableProvision())) return false;
			if (!Objects.equals(extendibleProvision, _that.getExtendibleProvision())) return false;
			if (!ListEquals.listEquals(additionalPayment, _that.getAdditionalPayment())) return false;
			if (!Objects.equals(additionalTerms, _that.getAdditionalTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (swapStream != null ? swapStream.hashCode() : 0);
			_result = 31 * _result + (earlyTerminationProvision != null ? earlyTerminationProvision.hashCode() : 0);
			_result = 31 * _result + (cancelableProvision != null ? cancelableProvision.hashCode() : 0);
			_result = 31 * _result + (extendibleProvision != null ? extendibleProvision.hashCode() : 0);
			_result = 31 * _result + (additionalPayment != null ? additionalPayment.hashCode() : 0);
			_result = 31 * _result + (additionalTerms != null ? additionalTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwapBuilder {" +
				"swapStream=" + this.swapStream + ", " +
				"earlyTerminationProvision=" + this.earlyTerminationProvision + ", " +
				"cancelableProvision=" + this.cancelableProvision + ", " +
				"extendibleProvision=" + this.extendibleProvision + ", " +
				"additionalPayment=" + this.additionalPayment + ", " +
				"additionalTerms=" + this.additionalTerms +
			'}' + " " + super.toString();
		}
	}
}
