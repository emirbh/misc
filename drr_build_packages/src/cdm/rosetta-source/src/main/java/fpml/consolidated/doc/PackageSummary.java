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
import fpml.consolidated.doc.meta.PackageSummaryMeta;
import fpml.consolidated.shared.IssuerTradeId;
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
 * version "recordkeeping-5.13"
 *
 * Provision Summary information about a trade package.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Summary information about a trade package.
 *
 */
@RosettaDataType(value="PackageSummary", builder=PackageSummary.PackageSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PackageSummary", model="fpml", builder=PackageSummary.PackageSummaryBuilderImpl.class, version="2.1.1")
public interface PackageSummary extends RosettaModelObject {

	PackageSummaryMeta metaData = new PackageSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Unique identifier of the trade package.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Unique identifier of the trade package.
	 *
	 */
	IssuerTradeId getPackageIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Unique identifier of the order that generated the trade package.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Unique identifier of the order that generated the trade package.
	 *
	 */
	OrderIdentifier getOrderIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the package type. Domain is defined within the packageTypeScheme and includes values such as: Butterfly, CalendarRoll, CalendarSpread, etc. The complete list is available at: http://www.fpml.org/coding-scheme/package-type
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the package type. Domain is defined within the packageTypeScheme and includes values such as: Butterfly, CalendarRoll, CalendarSpread, etc. The complete list is available at: http://www.fpml.org/coding-scheme/package-type
	 *
	 */
	List<? extends PackageType> getPackageType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Size of the trade package.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Size of the trade package.
	 *
	 */
	BigDecimal getSize();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Sequence number is used to identify the ordinal position of the trade within the enclosing package, e.g. number 1 of 3, 2 of 3, etc, where 3 equals package size. It’s intended to assist with ordering and reconciliation.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Sequence number is used to identify the ordinal position of the trade within the enclosing package, e.g. number 1 of 3, 2 of 3, etc, where 3 equals package size. It’s intended to assist with ordering and reconciliation.
	 *
	 */
	BigDecimal getSequenceNumber();

	/*********************** Build Methods  ***********************/
	PackageSummary build();
	
	PackageSummary.PackageSummaryBuilder toBuilder();
	
	static PackageSummary.PackageSummaryBuilder builder() {
		return new PackageSummary.PackageSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PackageSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PackageSummary> getType() {
		return PackageSummary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("packageIdentifier"), processor, IssuerTradeId.class, getPackageIdentifier());
		processRosetta(path.newSubPath("orderIdentifier"), processor, OrderIdentifier.class, getOrderIdentifier());
		processRosetta(path.newSubPath("packageType"), processor, PackageType.class, getPackageType());
		processor.processBasic(path.newSubPath("size"), BigDecimal.class, getSize(), this);
		processor.processBasic(path.newSubPath("sequenceNumber"), BigDecimal.class, getSequenceNumber(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PackageSummaryBuilder extends PackageSummary, RosettaModelObjectBuilder {
		IssuerTradeId.IssuerTradeIdBuilder getOrCreatePackageIdentifier();
		@Override
		IssuerTradeId.IssuerTradeIdBuilder getPackageIdentifier();
		OrderIdentifier.OrderIdentifierBuilder getOrCreateOrderIdentifier();
		@Override
		OrderIdentifier.OrderIdentifierBuilder getOrderIdentifier();
		PackageType.PackageTypeBuilder getOrCreatePackageType(int index);
		@Override
		List<? extends PackageType.PackageTypeBuilder> getPackageType();
		PackageSummary.PackageSummaryBuilder setPackageIdentifier(IssuerTradeId packageIdentifier);
		PackageSummary.PackageSummaryBuilder setOrderIdentifier(OrderIdentifier orderIdentifier);
		PackageSummary.PackageSummaryBuilder addPackageType(PackageType packageType);
		PackageSummary.PackageSummaryBuilder addPackageType(PackageType packageType, int idx);
		PackageSummary.PackageSummaryBuilder addPackageType(List<? extends PackageType> packageType);
		PackageSummary.PackageSummaryBuilder setPackageType(List<? extends PackageType> packageType);
		PackageSummary.PackageSummaryBuilder setSize(BigDecimal size);
		PackageSummary.PackageSummaryBuilder setSequenceNumber(BigDecimal sequenceNumber);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("packageIdentifier"), processor, IssuerTradeId.IssuerTradeIdBuilder.class, getPackageIdentifier());
			processRosetta(path.newSubPath("orderIdentifier"), processor, OrderIdentifier.OrderIdentifierBuilder.class, getOrderIdentifier());
			processRosetta(path.newSubPath("packageType"), processor, PackageType.PackageTypeBuilder.class, getPackageType());
			processor.processBasic(path.newSubPath("size"), BigDecimal.class, getSize(), this);
			processor.processBasic(path.newSubPath("sequenceNumber"), BigDecimal.class, getSequenceNumber(), this);
		}
		

		PackageSummary.PackageSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of PackageSummary  ***********************/
	class PackageSummaryImpl implements PackageSummary {
		private final IssuerTradeId packageIdentifier;
		private final OrderIdentifier orderIdentifier;
		private final List<? extends PackageType> packageType;
		private final BigDecimal size;
		private final BigDecimal sequenceNumber;
		
		protected PackageSummaryImpl(PackageSummary.PackageSummaryBuilder builder) {
			this.packageIdentifier = ofNullable(builder.getPackageIdentifier()).map(f->f.build()).orElse(null);
			this.orderIdentifier = ofNullable(builder.getOrderIdentifier()).map(f->f.build()).orElse(null);
			this.packageType = ofNullable(builder.getPackageType()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.size = builder.getSize();
			this.sequenceNumber = builder.getSequenceNumber();
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
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sequenceNumber")
		public BigDecimal getSequenceNumber() {
			return sequenceNumber;
		}
		
		@Override
		public PackageSummary build() {
			return this;
		}
		
		@Override
		public PackageSummary.PackageSummaryBuilder toBuilder() {
			PackageSummary.PackageSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PackageSummary.PackageSummaryBuilder builder) {
			ofNullable(getPackageIdentifier()).ifPresent(builder::setPackageIdentifier);
			ofNullable(getOrderIdentifier()).ifPresent(builder::setOrderIdentifier);
			ofNullable(getPackageType()).ifPresent(builder::setPackageType);
			ofNullable(getSize()).ifPresent(builder::setSize);
			ofNullable(getSequenceNumber()).ifPresent(builder::setSequenceNumber);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PackageSummary _that = getType().cast(o);
		
			if (!Objects.equals(packageIdentifier, _that.getPackageIdentifier())) return false;
			if (!Objects.equals(orderIdentifier, _that.getOrderIdentifier())) return false;
			if (!ListEquals.listEquals(packageType, _that.getPackageType())) return false;
			if (!Objects.equals(size, _that.getSize())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (packageIdentifier != null ? packageIdentifier.hashCode() : 0);
			_result = 31 * _result + (orderIdentifier != null ? orderIdentifier.hashCode() : 0);
			_result = 31 * _result + (packageType != null ? packageType.hashCode() : 0);
			_result = 31 * _result + (size != null ? size.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PackageSummary {" +
				"packageIdentifier=" + this.packageIdentifier + ", " +
				"orderIdentifier=" + this.orderIdentifier + ", " +
				"packageType=" + this.packageType + ", " +
				"size=" + this.size + ", " +
				"sequenceNumber=" + this.sequenceNumber +
			'}';
		}
	}

	/*********************** Builder Implementation of PackageSummary  ***********************/
	class PackageSummaryBuilderImpl implements PackageSummary.PackageSummaryBuilder {
	
		protected IssuerTradeId.IssuerTradeIdBuilder packageIdentifier;
		protected OrderIdentifier.OrderIdentifierBuilder orderIdentifier;
		protected List<PackageType.PackageTypeBuilder> packageType = new ArrayList<>();
		protected BigDecimal size;
		protected BigDecimal sequenceNumber;
		
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
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sequenceNumber")
		public BigDecimal getSequenceNumber() {
			return sequenceNumber;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public PackageSummary.PackageSummaryBuilder setPackageIdentifier(IssuerTradeId _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("orderIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("orderIdentifier")
		@Override
		public PackageSummary.PackageSummaryBuilder setOrderIdentifier(OrderIdentifier _orderIdentifier) {
			this.orderIdentifier = _orderIdentifier == null ? null : _orderIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("packageType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("packageType")
		@Override
		public PackageSummary.PackageSummaryBuilder addPackageType(PackageType _packageType) {
			if (_packageType != null) {
				this.packageType.add(_packageType.toBuilder());
			}
			return this;
		}
		
		@Override
		public PackageSummary.PackageSummaryBuilder addPackageType(PackageType _packageType, int idx) {
			getIndex(this.packageType, idx, () -> _packageType.toBuilder());
			return this;
		}
		
		@Override
		public PackageSummary.PackageSummaryBuilder addPackageType(List<? extends PackageType> packageTypes) {
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
		public PackageSummary.PackageSummaryBuilder setPackageType(List<? extends PackageType> packageTypes) {
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
		public PackageSummary.PackageSummaryBuilder setSize(BigDecimal _size) {
			this.size = _size == null ? null : _size;
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public PackageSummary.PackageSummaryBuilder setSequenceNumber(BigDecimal _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@Override
		public PackageSummary build() {
			return new PackageSummary.PackageSummaryImpl(this);
		}
		
		@Override
		public PackageSummary.PackageSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PackageSummary.PackageSummaryBuilder prune() {
			if (packageIdentifier!=null && !packageIdentifier.prune().hasData()) packageIdentifier = null;
			if (orderIdentifier!=null && !orderIdentifier.prune().hasData()) orderIdentifier = null;
			packageType = packageType.stream().filter(b->b!=null).<PackageType.PackageTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPackageIdentifier()!=null && getPackageIdentifier().hasData()) return true;
			if (getOrderIdentifier()!=null && getOrderIdentifier().hasData()) return true;
			if (getPackageType()!=null && getPackageType().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSize()!=null) return true;
			if (getSequenceNumber()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PackageSummary.PackageSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PackageSummary.PackageSummaryBuilder o = (PackageSummary.PackageSummaryBuilder) other;
			
			merger.mergeRosetta(getPackageIdentifier(), o.getPackageIdentifier(), this::setPackageIdentifier);
			merger.mergeRosetta(getOrderIdentifier(), o.getOrderIdentifier(), this::setOrderIdentifier);
			merger.mergeRosetta(getPackageType(), o.getPackageType(), this::getOrCreatePackageType);
			
			merger.mergeBasic(getSize(), o.getSize(), this::setSize);
			merger.mergeBasic(getSequenceNumber(), o.getSequenceNumber(), this::setSequenceNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PackageSummary _that = getType().cast(o);
		
			if (!Objects.equals(packageIdentifier, _that.getPackageIdentifier())) return false;
			if (!Objects.equals(orderIdentifier, _that.getOrderIdentifier())) return false;
			if (!ListEquals.listEquals(packageType, _that.getPackageType())) return false;
			if (!Objects.equals(size, _that.getSize())) return false;
			if (!Objects.equals(sequenceNumber, _that.getSequenceNumber())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (packageIdentifier != null ? packageIdentifier.hashCode() : 0);
			_result = 31 * _result + (orderIdentifier != null ? orderIdentifier.hashCode() : 0);
			_result = 31 * _result + (packageType != null ? packageType.hashCode() : 0);
			_result = 31 * _result + (size != null ? size.hashCode() : 0);
			_result = 31 * _result + (sequenceNumber != null ? sequenceNumber.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PackageSummaryBuilder {" +
				"packageIdentifier=" + this.packageIdentifier + ", " +
				"orderIdentifier=" + this.orderIdentifier + ", " +
				"packageType=" + this.packageType + ", " +
				"size=" + this.size + ", " +
				"sequenceNumber=" + this.sequenceNumber +
			'}';
		}
	}
}
