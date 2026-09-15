package iso20022.auth030.hkma.tr;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import iso20022.auth030.hkma.tr.meta.TrancheIndicator3Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indication whether a derivative contract is tranched.
 * @version ${project.version}
 */
@RosettaDataType(value="TrancheIndicator3Choice__1", builder=TrancheIndicator3Choice__1.TrancheIndicator3Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TrancheIndicator3Choice__1", model="iso20022", builder=TrancheIndicator3Choice__1.TrancheIndicator3Choice__1BuilderImpl.class, version="${project.version}")
public interface TrancheIndicator3Choice__1 extends RosettaModelObject {

	TrancheIndicator3Choice__1Meta metaData = new TrancheIndicator3Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indication that derivative contract is tranched.
	 */
	Tranche3 getTrnchd();

	/*********************** Build Methods  ***********************/
	TrancheIndicator3Choice__1 build();
	
	TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder toBuilder();
	
	static TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder builder() {
		return new TrancheIndicator3Choice__1.TrancheIndicator3Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TrancheIndicator3Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TrancheIndicator3Choice__1> getType() {
		return TrancheIndicator3Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("trnchd"), processor, Tranche3.class, getTrnchd());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TrancheIndicator3Choice__1Builder extends TrancheIndicator3Choice__1, RosettaModelObjectBuilder {
		Tranche3.Tranche3Builder getOrCreateTrnchd();
		@Override
		Tranche3.Tranche3Builder getTrnchd();
		TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder setTrnchd(Tranche3 trnchd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("trnchd"), processor, Tranche3.Tranche3Builder.class, getTrnchd());
		}
		

		TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of TrancheIndicator3Choice__1  ***********************/
	class TrancheIndicator3Choice__1Impl implements TrancheIndicator3Choice__1 {
		private final Tranche3 trnchd;
		
		protected TrancheIndicator3Choice__1Impl(TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder builder) {
			this.trnchd = ofNullable(builder.getTrnchd()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("trnchd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trnchd")
		public Tranche3 getTrnchd() {
			return trnchd;
		}
		
		@Override
		public TrancheIndicator3Choice__1 build() {
			return this;
		}
		
		@Override
		public TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder toBuilder() {
			TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder builder) {
			ofNullable(getTrnchd()).ifPresent(builder::setTrnchd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TrancheIndicator3Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(trnchd, _that.getTrnchd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trnchd != null ? trnchd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TrancheIndicator3Choice__1 {" +
				"trnchd=" + this.trnchd +
			'}';
		}
	}

	/*********************** Builder Implementation of TrancheIndicator3Choice__1  ***********************/
	class TrancheIndicator3Choice__1BuilderImpl implements TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder {
	
		protected Tranche3.Tranche3Builder trnchd;
		
		@Override
		@RosettaAttribute("trnchd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("trnchd")
		public Tranche3.Tranche3Builder getTrnchd() {
			return trnchd;
		}
		
		@Override
		public Tranche3.Tranche3Builder getOrCreateTrnchd() {
			Tranche3.Tranche3Builder result;
			if (trnchd!=null) {
				result = trnchd;
			}
			else {
				result = trnchd = Tranche3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("trnchd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("trnchd")
		@Override
		public TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder setTrnchd(Tranche3 _trnchd) {
			this.trnchd = _trnchd == null ? null : _trnchd.toBuilder();
			return this;
		}
		
		@Override
		public TrancheIndicator3Choice__1 build() {
			return new TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Impl(this);
		}
		
		@Override
		public TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder prune() {
			if (trnchd!=null && !trnchd.prune().hasData()) trnchd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTrnchd()!=null && getTrnchd().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder o = (TrancheIndicator3Choice__1.TrancheIndicator3Choice__1Builder) other;
			
			merger.mergeRosetta(getTrnchd(), o.getTrnchd(), this::setTrnchd);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TrancheIndicator3Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(trnchd, _that.getTrnchd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (trnchd != null ? trnchd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TrancheIndicator3Choice__1Builder {" +
				"trnchd=" + this.trnchd +
			'}';
		}
	}
}
