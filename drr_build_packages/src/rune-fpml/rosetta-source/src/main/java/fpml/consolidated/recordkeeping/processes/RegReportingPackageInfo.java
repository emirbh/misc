package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.recordkeeping.processes.meta.RegReportingPackageInfoMeta;
import fpml.consolidated.shared.IssuerTradeId;
import java.util.Objects;

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
 */
@RosettaDataType(value="RegReportingPackageInfo", builder=RegReportingPackageInfo.RegReportingPackageInfoBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegReportingPackageInfo", model="fpml", builder=RegReportingPackageInfo.RegReportingPackageInfoBuilderImpl.class, version="2.1.1")
public interface RegReportingPackageInfo extends RosettaModelObject {

	RegReportingPackageInfoMeta metaData = new RegReportingPackageInfoMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	IssuerTradeId getPackageIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	Boolean getPacakageWithNonReportableComponent();

	/*********************** Build Methods  ***********************/
	RegReportingPackageInfo build();
	
	RegReportingPackageInfo.RegReportingPackageInfoBuilder toBuilder();
	
	static RegReportingPackageInfo.RegReportingPackageInfoBuilder builder() {
		return new RegReportingPackageInfo.RegReportingPackageInfoBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegReportingPackageInfo> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegReportingPackageInfo> getType() {
		return RegReportingPackageInfo.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("packageIdentifier"), processor, IssuerTradeId.class, getPackageIdentifier());
		processor.processBasic(path.newSubPath("pacakageWithNonReportableComponent"), Boolean.class, getPacakageWithNonReportableComponent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegReportingPackageInfoBuilder extends RegReportingPackageInfo, RosettaModelObjectBuilder {
		IssuerTradeId.IssuerTradeIdBuilder getOrCreatePackageIdentifier();
		@Override
		IssuerTradeId.IssuerTradeIdBuilder getPackageIdentifier();
		RegReportingPackageInfo.RegReportingPackageInfoBuilder setPackageIdentifier(IssuerTradeId packageIdentifier);
		RegReportingPackageInfo.RegReportingPackageInfoBuilder setPacakageWithNonReportableComponent(Boolean pacakageWithNonReportableComponent);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("packageIdentifier"), processor, IssuerTradeId.IssuerTradeIdBuilder.class, getPackageIdentifier());
			processor.processBasic(path.newSubPath("pacakageWithNonReportableComponent"), Boolean.class, getPacakageWithNonReportableComponent(), this);
		}
		

		RegReportingPackageInfo.RegReportingPackageInfoBuilder prune();
	}

	/*********************** Immutable Implementation of RegReportingPackageInfo  ***********************/
	class RegReportingPackageInfoImpl implements RegReportingPackageInfo {
		private final IssuerTradeId packageIdentifier;
		private final Boolean pacakageWithNonReportableComponent;
		
		protected RegReportingPackageInfoImpl(RegReportingPackageInfo.RegReportingPackageInfoBuilder builder) {
			this.packageIdentifier = ofNullable(builder.getPackageIdentifier()).map(f->f.build()).orElse(null);
			this.pacakageWithNonReportableComponent = builder.getPacakageWithNonReportableComponent();
		}
		
		@Override
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("packageIdentifier")
		public IssuerTradeId getPackageIdentifier() {
			return packageIdentifier;
		}
		
		@Override
		@RosettaAttribute("pacakageWithNonReportableComponent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pacakageWithNonReportableComponent")
		public Boolean getPacakageWithNonReportableComponent() {
			return pacakageWithNonReportableComponent;
		}
		
		@Override
		public RegReportingPackageInfo build() {
			return this;
		}
		
		@Override
		public RegReportingPackageInfo.RegReportingPackageInfoBuilder toBuilder() {
			RegReportingPackageInfo.RegReportingPackageInfoBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegReportingPackageInfo.RegReportingPackageInfoBuilder builder) {
			ofNullable(getPackageIdentifier()).ifPresent(builder::setPackageIdentifier);
			ofNullable(getPacakageWithNonReportableComponent()).ifPresent(builder::setPacakageWithNonReportableComponent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegReportingPackageInfo _that = getType().cast(o);
		
			if (!Objects.equals(packageIdentifier, _that.getPackageIdentifier())) return false;
			if (!Objects.equals(pacakageWithNonReportableComponent, _that.getPacakageWithNonReportableComponent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (packageIdentifier != null ? packageIdentifier.hashCode() : 0);
			_result = 31 * _result + (pacakageWithNonReportableComponent != null ? pacakageWithNonReportableComponent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegReportingPackageInfo {" +
				"packageIdentifier=" + this.packageIdentifier + ", " +
				"pacakageWithNonReportableComponent=" + this.pacakageWithNonReportableComponent +
			'}';
		}
	}

	/*********************** Builder Implementation of RegReportingPackageInfo  ***********************/
	class RegReportingPackageInfoBuilderImpl implements RegReportingPackageInfo.RegReportingPackageInfoBuilder {
	
		protected IssuerTradeId.IssuerTradeIdBuilder packageIdentifier;
		protected Boolean pacakageWithNonReportableComponent;
		
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
		@RosettaAttribute("pacakageWithNonReportableComponent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pacakageWithNonReportableComponent")
		public Boolean getPacakageWithNonReportableComponent() {
			return pacakageWithNonReportableComponent;
		}
		
		@RosettaAttribute("packageIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("packageIdentifier")
		@Override
		public RegReportingPackageInfo.RegReportingPackageInfoBuilder setPackageIdentifier(IssuerTradeId _packageIdentifier) {
			this.packageIdentifier = _packageIdentifier == null ? null : _packageIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pacakageWithNonReportableComponent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pacakageWithNonReportableComponent")
		@Override
		public RegReportingPackageInfo.RegReportingPackageInfoBuilder setPacakageWithNonReportableComponent(Boolean _pacakageWithNonReportableComponent) {
			this.pacakageWithNonReportableComponent = _pacakageWithNonReportableComponent == null ? null : _pacakageWithNonReportableComponent;
			return this;
		}
		
		@Override
		public RegReportingPackageInfo build() {
			return new RegReportingPackageInfo.RegReportingPackageInfoImpl(this);
		}
		
		@Override
		public RegReportingPackageInfo.RegReportingPackageInfoBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegReportingPackageInfo.RegReportingPackageInfoBuilder prune() {
			if (packageIdentifier!=null && !packageIdentifier.prune().hasData()) packageIdentifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPackageIdentifier()!=null && getPackageIdentifier().hasData()) return true;
			if (getPacakageWithNonReportableComponent()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegReportingPackageInfo.RegReportingPackageInfoBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegReportingPackageInfo.RegReportingPackageInfoBuilder o = (RegReportingPackageInfo.RegReportingPackageInfoBuilder) other;
			
			merger.mergeRosetta(getPackageIdentifier(), o.getPackageIdentifier(), this::setPackageIdentifier);
			
			merger.mergeBasic(getPacakageWithNonReportableComponent(), o.getPacakageWithNonReportableComponent(), this::setPacakageWithNonReportableComponent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegReportingPackageInfo _that = getType().cast(o);
		
			if (!Objects.equals(packageIdentifier, _that.getPackageIdentifier())) return false;
			if (!Objects.equals(pacakageWithNonReportableComponent, _that.getPacakageWithNonReportableComponent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (packageIdentifier != null ? packageIdentifier.hashCode() : 0);
			_result = 31 * _result + (pacakageWithNonReportableComponent != null ? pacakageWithNonReportableComponent.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegReportingPackageInfoBuilder {" +
				"packageIdentifier=" + this.packageIdentifier + ", " +
				"pacakageWithNonReportableComponent=" + this.pacakageWithNonReportableComponent +
			'}';
		}
	}
}
