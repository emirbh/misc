package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.PackageHeaderMeta;
import fpml.consolidated.doc.OrderIdentifier;
import fpml.consolidated.doc.PackageInformation;
import fpml.consolidated.doc.PackageType;
import fpml.consolidated.shared.IssuerTradeId;
import fpml.consolidated.shared.OriginatingEvent;
import java.math.BigDecimal;
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
 * Provision Identifying information for a tradePackage (a bundle of trades).
 *
 */
@RosettaDataType(value="PackageHeader", builder=PackageHeader.PackageHeaderBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PackageHeader", model="fpml", builder=PackageHeader.PackageHeaderBuilderImpl.class, version="2.1.1")
public interface PackageHeader extends RosettaModelObject {

	PackageHeaderMeta metaData = new PackageHeaderMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	IssuerTradeId getPackageIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	OrderIdentifier getOrderIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Classification of the package. FpML has defined a list of coding scheme values. Different organizations might have different naming schemes for the packages so the multiplicity of unbounded is meant to support synonyms but it does not mean that a trade has multiple package types.
	 *
	 */
	List<? extends PackageType> getPackageType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	BigDecimal getSize();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to describe why a package was created. This can be used to provide context for a newly created package that is not part of a post-trade event. For example, it can report that the package was created as a result of netting activity, or due to a transfer, an allocation process, etc.
	 *
	 */
	OriginatingEvent getOriginatingEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	PackageInformation getPackageInformation();

	/*********************** Build Methods  ***********************/
	PackageHeader build();
	
	PackageHeader.PackageHeaderBuilder toBuilder();
	
	static PackageHeader.PackageHeaderBuilder builder() {
		return new PackageHeader.PackageHeaderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PackageHeader> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PackageHeader> getType() {
		return PackageHeader.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("packageIdentifier"), processor, IssuerTradeId.class, getPackageIdentifier());
		processRosetta(path.newSubPath("orderIdentifier"), processor, OrderIdentifier.class, getOrderIdentifier());
		processRosetta(path.newSubPath("packageType"), processor, PackageType.class, getPackageType());
		processor.processBasic(path.newSubPath("size"), BigDecimal.class, getSize(), this);
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("packageInformation"), processor, PackageInformation.class, getPackageInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PackageHeaderBuilder extends PackageHeader, RosettaModelObjectBuilder {
		IssuerTradeId.IssuerTradeIdBuilder getOrCreatePackageIdentifier();
		@Override
		IssuerTradeId.IssuerTradeIdBuilder getPackageIdentifier();
		OrderIdentifier.OrderIdentifierBuilder getOrCreateOrderIdentifier();
		@Override
		OrderIdentifier.OrderIdentifierBuilder getOrderIdentifier();
		PackageType.PackageTypeBuilder getOrCreatePackageType(int index);
		@Override
		List<? extends PackageType.PackageTypeBuilder> getPackageType();
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		@Override
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		PackageInformation.PackageInformationBuilder getOrCreatePackageInformation();
		@Override
		PackageInformation.PackageInformationBuilder getPackageInformation();
		PackageHeader.PackageHeaderBuilder setPackageIdentifier(IssuerTradeId packageIdentifier);
		PackageHeader.PackageHeaderBuilder setOrderIdentifier(OrderIdentifier orderIdentifier);
		PackageHeader.PackageHeaderBuilder addPackageType(PackageType packageType);
		PackageHeader.PackageHeaderBuilder addPackageType(PackageType packageType, int idx);
		PackageHeader.PackageHeaderBuilder addPackageType(List<? extends PackageType> packageType);
		PackageHeader.PackageHeaderBuilder setPackageType(List<? extends PackageType> packageType);
		PackageHeader.PackageHeaderBuilder setSize(BigDecimal size);
		PackageHeader.PackageHeaderBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		PackageHeader.PackageHeaderBuilder setPackageInformation(PackageInformation packageInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("packageIdentifier"), processor, IssuerTradeId.IssuerTradeIdBuilder.class, getPackageIdentifier());
			processRosetta(path.newSubPath("orderIdentifier"), processor, OrderIdentifier.OrderIdentifierBuilder.class, getOrderIdentifier());
			processRosetta(path.newSubPath("packageType"), processor, PackageType.PackageTypeBuilder.class, getPackageType());
			processor.processBasic(path.newSubPath("size"), BigDecimal.class, getSize(), this);
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("packageInformation"), processor, PackageInformation.PackageInformationBuilder.class, getPackageInformation());
		}
		

		PackageHeader.PackageHeaderBuilder prune();
	}

	/*********************** Immutable Implementation of PackageHeader  ***********************/
	class PackageHeaderImpl implements PackageHeader {
		private final IssuerTradeId packageIdentifier;
		private final OrderIdentifier orderIdentifier;
		private final List<? extends PackageType> packageType;
		private final BigDecimal size;
		private final OriginatingEvent originatingEvent;
		private final PackageInformation packageInformation;
		
		protected PackageHeaderImpl(PackageHeader.PackageHeaderBuilder builder) {
			this.packageIdentifier = ofNullable(builder.getPackageIdentifier()).map(f->f.build()).orElse(null);
			this.orderIdentifier = ofNullable(builder.getOrderIdentifier()).map(f->f.build()).orElse(null);
			this.packageType = ofNullable(builder.getPackageType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.size = builder.getSize();
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.packageInformation = ofNullable(builder.getPackageInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageIdentifier")
		public IssuerTradeId getPackageIdentifier() {
			return packageIdentifier;
		}
		
		@Override
		@RosettaAttribute("orderIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("orderIdentifier")
		public OrderIdentifier getOrderIdentifier() {
			return orderIdentifier;
		}
		
		@Override
		@RosettaAttribute("packageType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("packageType")
		public List<? extends PackageType> getPackageType() {
			return packageType;
		}
		
		@Override
		@RosettaAttribute("size")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("size")
		public BigDecimal getSize() {
			return size;
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingEvent")
		public OriginatingEvent getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		@RosettaAttribute("packageInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageInformation")
		public PackageInformation getPackageInformation() {
			return packageInformation;
		}
		
		@Override
		public PackageHeader build() {
			return this;
		}
		
		@Override
		public PackageHeader.PackageHeaderBuilder toBuilder() {
			PackageHeader.PackageHeaderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PackageHeader.PackageHeaderBuilder builder) {
			ofNullable(getPackageIdentifier()).ifPresent(builder::setPackageIdentifier);
			ofNullable(getOrderIdentifier()).ifPresent(builder::setOrderIdentifier);
			ofNullable(getPackageType()).ifPresent(builder::setPackageType);
			ofNullable(getSize()).ifPresent(builder::setSize);
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getPackageInformation()).ifPresent(builder::setPackageInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PackageHeader _that = getType().cast(o);
		
			if (!Objects.equals(packageIdentifier, _that.getPackageIdentifier())) return false;
			if (!Objects.equals(orderIdentifier, _that.getOrderIdentifier())) return false;
			if (!ListEquals.listEquals(packageType, _that.getPackageType())) return false;
			if (!Objects.equals(size, _that.getSize())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(packageInformation, _that.getPackageInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (packageIdentifier != null ? packageIdentifier.hashCode() : 0);
			_result = 31 * _result + (orderIdentifier != null ? orderIdentifier.hashCode() : 0);
			_result = 31 * _result + (packageType != null ? packageType.hashCode() : 0);
			_result = 31 * _result + (size != null ? size.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (packageInformation != null ? packageInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PackageHeader {" +
				"packageIdentifier=" + this.packageIdentifier + ", " +
				"orderIdentifier=" + this.orderIdentifier + ", " +
				"packageType=" + this.packageType + ", " +
				"size=" + this.size + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"packageInformation=" + this.packageInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of PackageHeader  ***********************/
	class PackageHeaderBuilderImpl implements PackageHeader.PackageHeaderBuilder {
	
		protected IssuerTradeId.IssuerTradeIdBuilder packageIdentifier;
		protected OrderIdentifier.OrderIdentifierBuilder orderIdentifier;
		protected List<PackageType.PackageTypeBuilder> packageType = new ArrayList<>();
		protected BigDecimal size;
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected PackageInformation.PackageInformationBuilder packageInformation;
		
		@Override
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageIdentifier")
		public IssuerTradeId.IssuerTradeIdBuilder getPackageIdentifier() {
			return packageIdentifier;
		}
		
		@Override
		public IssuerTradeId.IssuerTradeIdBuilder getOrCreatePackageIdentifier() {
			IssuerTradeId.IssuerTradeIdBuilder result;
			if (packageIdentifier!=null) {
				result = packageIdentifier;
			}
			else {
				result = packageIdentifier = IssuerTradeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("orderIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("orderIdentifier")
		public OrderIdentifier.OrderIdentifierBuilder getOrderIdentifier() {
			return orderIdentifier;
		}
		
		@Override
		public OrderIdentifier.OrderIdentifierBuilder getOrCreateOrderIdentifier() {
			OrderIdentifier.OrderIdentifierBuilder result;
			if (orderIdentifier!=null) {
				result = orderIdentifier;
			}
			else {
				result = orderIdentifier = OrderIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("packageType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("packageType")
		public List<? extends PackageType.PackageTypeBuilder> getPackageType() {
			return packageType;
		}
		
		@Override
		public PackageType.PackageTypeBuilder getOrCreatePackageType(int index) {
			if (packageType==null) {
				this.packageType = new ArrayList<>();
			}
			return getIndex(packageType, index, () -> {
						PackageType.PackageTypeBuilder newPackageType = PackageType.builder();
						return newPackageType;
					});
		}
		
		@Override
		@RosettaAttribute("size")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("size")
		public BigDecimal getSize() {
			return size;
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingEvent")
		public OriginatingEvent.OriginatingEventBuilder getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		public OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent() {
			OriginatingEvent.OriginatingEventBuilder result;
			if (originatingEvent!=null) {
				result = originatingEvent;
			}
			else {
				result = originatingEvent = OriginatingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("packageInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageInformation")
		public PackageInformation.PackageInformationBuilder getPackageInformation() {
			return packageInformation;
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder getOrCreatePackageInformation() {
			PackageInformation.PackageInformationBuilder result;
			if (packageInformation!=null) {
				result = packageInformation;
			}
			else {
				result = packageInformation = PackageInformation.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public PackageHeader.PackageHeaderBuilder setPackageIdentifier(IssuerTradeId _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("orderIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("orderIdentifier")
		@Override
		public PackageHeader.PackageHeaderBuilder setOrderIdentifier(OrderIdentifier _orderIdentifier) {
			this.orderIdentifier = _orderIdentifier == null ? null : _orderIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("packageType")
		@Override
		public PackageHeader.PackageHeaderBuilder addPackageType(PackageType _packageType) {
			if (_packageType != null) {
				this.packageType.add(_packageType.toBuilder());
			}
			return this;
		}
		
		@Override
		public PackageHeader.PackageHeaderBuilder addPackageType(PackageType _packageType, int idx) {
			getIndex(this.packageType, idx, () -> _packageType.toBuilder());
			return this;
		}
		
		@Override
		public PackageHeader.PackageHeaderBuilder addPackageType(List<? extends PackageType> packageTypes) {
			if (packageTypes != null) {
				for (final PackageType toAdd : packageTypes) {
					this.packageType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("packageType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("packageType")
		@Override
		public PackageHeader.PackageHeaderBuilder setPackageType(List<? extends PackageType> packageTypes) {
			if (packageTypes == null) {
				this.packageType = new ArrayList<>();
			} else {
				this.packageType = packageTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("size")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("size")
		@Override
		public PackageHeader.PackageHeaderBuilder setSize(BigDecimal _size) {
			this.size = _size == null ? null : _size;
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public PackageHeader.PackageHeaderBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageInformation")
		@Override
		public PackageHeader.PackageHeaderBuilder setPackageInformation(PackageInformation _packageInformation) {
			this.packageInformation = _packageInformation == null ? null : _packageInformation.toBuilder();
			return this;
		}
		
		@Override
		public PackageHeader build() {
			return new PackageHeader.PackageHeaderImpl(this);
		}
		
		@Override
		public PackageHeader.PackageHeaderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PackageHeader.PackageHeaderBuilder prune() {
			if (packageIdentifier!=null && !packageIdentifier.prune().hasData()) packageIdentifier = null;
			if (orderIdentifier!=null && !orderIdentifier.prune().hasData()) orderIdentifier = null;
			packageType = packageType.stream().filter(b->b!=null).<PackageType.PackageTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			if (packageInformation!=null && !packageInformation.prune().hasData()) packageInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPackageIdentifier()!=null && getPackageIdentifier().hasData()) return true;
			if (getOrderIdentifier()!=null && getOrderIdentifier().hasData()) return true;
			if (getPackageType()!=null && getPackageType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSize()!=null) return true;
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getPackageInformation()!=null && getPackageInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PackageHeader.PackageHeaderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PackageHeader.PackageHeaderBuilder o = (PackageHeader.PackageHeaderBuilder) other;
			
			merger.mergeRosetta(getPackageIdentifier(), o.getPackageIdentifier(), this::setPackageIdentifier);
			merger.mergeRosetta(getOrderIdentifier(), o.getOrderIdentifier(), this::setOrderIdentifier);
			merger.mergeRosetta(getPackageType(), o.getPackageType(), this::getOrCreatePackageType);
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getPackageInformation(), o.getPackageInformation(), this::setPackageInformation);
			
			merger.mergeBasic(getSize(), o.getSize(), this::setSize);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PackageHeader _that = getType().cast(o);
		
			if (!Objects.equals(packageIdentifier, _that.getPackageIdentifier())) return false;
			if (!Objects.equals(orderIdentifier, _that.getOrderIdentifier())) return false;
			if (!ListEquals.listEquals(packageType, _that.getPackageType())) return false;
			if (!Objects.equals(size, _that.getSize())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(packageInformation, _that.getPackageInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (packageIdentifier != null ? packageIdentifier.hashCode() : 0);
			_result = 31 * _result + (orderIdentifier != null ? orderIdentifier.hashCode() : 0);
			_result = 31 * _result + (packageType != null ? packageType.hashCode() : 0);
			_result = 31 * _result + (size != null ? size.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (packageInformation != null ? packageInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PackageHeaderBuilder {" +
				"packageIdentifier=" + this.packageIdentifier + ", " +
				"orderIdentifier=" + this.orderIdentifier + ", " +
				"packageType=" + this.packageType + ", " +
				"size=" + this.size + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"packageInformation=" + this.packageInformation +
			'}';
		}
	}
}
